package comPackage.phonepe.services;



import comPackage.phonepe.filters.FilterStrategy;
import comPackage.phonepe.models.Issue;

import java.util.List;

public interface IssueService {
    Issue createIssue(String transactionId, String issueType, String subject, String description, String email);
    Issue getIssue(String issueId);
    List<Issue> getIssues(List<FilterStrategy> filterStrategies);
}
