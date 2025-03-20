package comPackage.phonepe.services;

import comPackage.phonepe.models.Status;
import comPackage.phonepe.strategy.IssueStrategy;
import comPackage.phonepe.models.Agent;
import comPackage.phonepe.models.Issue;
import comPackage.phonepe.models.IssueType;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class AgentServiceImpl implements AgentService {

    private final Map<String, Agent> agentMap;
    private static final AtomicInteger agentId= new AtomicInteger(0);
    private final IssueService issueService;
    private final IssueStrategy issueStrategy;

    private final Queue<Issue> pendingIssues;

    public AgentServiceImpl( IssueService issueService, IssueStrategy issueStrategy) {
        this.agentMap = new LinkedHashMap<>();
        this.issueService = issueService;
        this.issueStrategy = issueStrategy;
        this.pendingIssues = new LinkedList<>();
    }


    @Override
    public Agent addAgent(String agentEmail, String agentName, List<IssueType> issueTypes, int agentCapacity) {
        int id = agentId.incrementAndGet();
        Agent agent = new Agent(String.valueOf(id), agentName, agentEmail, issueTypes, agentCapacity);
        agentMap.putIfAbsent(agent.getAgentId(), agent);
        return agent;
    }

    @Override
    public List<Issue> viewAgentsWorkHistory(String agentId) {
        if (Objects.nonNull(agentId)) {
            Agent agent = agentMap.get(agentId);
            return agent.getWorkHistory();
        }
        throw new IllegalArgumentException("this agent id doesnt exist ");
    }
    @Override
    public Map<String,List<Issue>> viewAgentsWorkHistory() {
                return agentMap.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().getWorkHistory()));
//        Map<String,List<Issue>> allAgentsWorkHistory = new HashMap<>();
//        for(Map.Entry<String,Agent> e: agentMap.entrySet()) {
//            String agentId = e.getKey();
//            Agent agent = e.getValue();
//            allAgentsWorkHistory.put(agentId,agent.getWorkHistory());
//        }
//        return allAgentsWorkHistory;

    }

    @Override
    public void assignIssue(String issueId) {
        Issue issue = issueService.getIssue(issueId);

        Optional<Agent> agent = issueStrategy.getAgentForIssue(issue.getIssueType(),agentMap.values().stream().toList());
        if (agent.isEmpty()) {
            issue.setStatus(Status.PENDING);
            pendingIssues.add(issue);
        } else {
            agent.get().assignIssue(issue);
        }
    }

    @Override
    public void updateIssue(String issueId, Status status, String resolution) {
        Issue issue = issueService.getIssue(issueId);
        this.getAgentById(issue.getAgentId()).updateIssue(issue, status, resolution);
    }

    @Override
    public void resolveIssue(String issueId, String resolution) {
        Issue issue = issueService.getIssue(issueId);
        Agent agent = this.getAgentById(issue.getAgentId());
        agent.updateIssue(issue, Status.RESOLVED, resolution);
        agent.removeIssue(issue);
    }

    @Override
    public List<Agent> getAgents() {
        return new ArrayList<>(agentMap.values());
    }


    public Agent getAgentById(String agentId) {
        Agent agent = agentMap.get(agentId);
        if(Objects.isNull(agent)){
            throw new RuntimeException("agentId doesnt exist"+agentId);
        }
        return agent;
    }

    public Queue<Issue> getPendingMap(){
        return this.pendingIssues;
    }
}
