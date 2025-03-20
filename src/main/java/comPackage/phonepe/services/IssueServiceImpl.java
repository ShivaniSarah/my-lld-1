package comPackage.phonepe.services;


import comPackage.phonepe.models.IssueType;
import comPackage.phonepe.filters.FilterStrategy;
import comPackage.phonepe.models.Issue;


import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class IssueServiceImpl implements IssueService {

    private final Map<String, Issue> issueMap;
    private static final AtomicInteger issueId= new AtomicInteger(0);

    public IssueServiceImpl() {
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
    public Issue getIssue(String issueId) {
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

}
