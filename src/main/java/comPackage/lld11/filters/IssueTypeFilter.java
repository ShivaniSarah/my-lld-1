package comPackage.lld11.filters;

import comPackage.lld11.models.Issue;
import comPackage.lld11.models.IssueType;

import java.util.List;
import java.util.stream.Collectors;

public class IssueTypeFilter extends FilterStrategy{

    private final IssueType issueType;

    public IssueTypeFilter(String issueType) {
        this.issueType = IssueType.getName(issueType);
    }

    @Override
    public List<Issue> filter(List<Issue> issues) {
        return issues.stream().filter(issue -> issue.getIssueType().equals(issueType)).collect(Collectors.toList());
    }
}
