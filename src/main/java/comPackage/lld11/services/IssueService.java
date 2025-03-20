package comPackage.lld11.services;



import comPackage.lld11.filters.FilterStrategy;
import comPackage.lld11.models.Issue;
import comPackage.lld11.models.Status;

import java.util.List;

public interface IssueService {
    Issue createIssue(String transactionId, String issueType, String subject, String description, String email);
    void assignIssue(String issueId);
    List<Issue> getIssues(List<FilterStrategy> filterStrategies);
    void updateIssue(String issueId, Status status, String resolution);
    void resolveIssue(String issueId, String resolution);
}
