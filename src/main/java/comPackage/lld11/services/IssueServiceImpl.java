package comPackage.lld11.services;


import comPackage.lld11.filters.FilterStrategy;
import comPackage.lld11.models.Agent;
import comPackage.lld11.models.Issue;
import comPackage.lld11.models.IssueType;
import comPackage.lld11.models.Status;
import comPackage.lld11.strategy.IssueStrategy;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class IssueServiceImpl implements IssueService{

    private final Map<String,Issue> issueMap;
    private static final AtomicInteger issueId= new AtomicInteger(0);
    private final IssueStrategy issueStrategy;
    private final Queue<Issue> pendingIssues;
    private final AgentService agentService;

    public IssueServiceImpl(IssueStrategy issueStrategy, AgentService agentService) {
        this.issueStrategy = issueStrategy;
        this.agentService = agentService;
        this.pendingIssues = new LinkedList<>();
        this.issueMap = new HashMap<>();
    }

    @Override
    public Issue createIssue(String transactionId, String issueType, String subject, String description, String email) {
        int id = issueId.incrementAndGet();
        Issue issue = new Issue(String.valueOf(id),transactionId, subject,description, IssueType.getName(issueType),email);
        issueMap.put(issue.getIssueId(), issue);
        return issue;
    }

    @Override
    public void assignIssue(String issueId) {
        Issue issue = getIssue(issueId);
        Optional<Agent> agent = issueStrategy.getAgentForIssue(issue);
        if (agent.isEmpty()) {
            issue.setStatus(Status.PENDING);
            pendingIssues.add(issue);
        } else {
            agent.get().assignIssue(issue);
            issue.setAgentId(agent.get().getAgentId());
        }
    }

    private Issue getIssue(String issueId) {
        Issue issue = issueMap.get(issueId);
        if (Objects.isNull(issue)) {
            throw new RuntimeException("Issue not present " + issueId);
        }
        return issue;
    }

    @Override
    public List<Issue> getIssues(List<FilterStrategy> filterStrategies) {
        List<Issue> issues = issueMap.values().stream().toList();
        for(FilterStrategy fs : filterStrategies) {
            issues = fs.filter(issues);
        }
        return issues;
    }

    @Override
    public void updateIssue(String issueId, Status status, String resolution) {
        Issue issue = getIssue(issueId);
        issue.setStatus(status);
        issue.setResolution(resolution);
    }

    @Override
    public void resolveIssue(String issueId, String resolution) {
        Issue issue = getIssue(issueId);
        issue.setStatus(Status.RESOLVED);
        issue.setResolution(resolution);
        agentService.markIssueAsResolved(issue);
    }
}
