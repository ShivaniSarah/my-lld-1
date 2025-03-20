package comPackage.lld11.services;

import comPackage.lld11.models.Issue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService{

    private  final Map<String, List<Issue>> issueMap;
    private final IssueService issueService;

    public CustomerServiceImpl(IssueService issueService) {
        this.issueService = issueService;
        this.issueMap = new HashMap<>();
    }

    @Override
    public Issue createIssue(String transactionId, String issueType, String subject, String description, String email) {
        Issue issue = issueService.createIssue(transactionId, issueType, subject, description, email);
        issueMap.getOrDefault(email, new ArrayList<>()).add(issue);
        return issue;
    }
}
