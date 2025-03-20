package comPackage.phonepe.filters;

import comPackage.phonepe.models.Issue;
import comPackage.phonepe.models.IssueType;

import java.util.List;
import java.util.stream.Collectors;

public class IssueTypeFilter extends FilterStrategy {

    private final IssueType issueType;

    public IssueTypeFilter(String issueType) {
        this.issueType = IssueType.getName(issueType);
    }

    @Override
    public List<Issue> filter(List<Issue> issues) {
        return issues.stream().filter(issue -> issue.getIssueType().equals(issueType)).collect(Collectors.toList());
    }
}
