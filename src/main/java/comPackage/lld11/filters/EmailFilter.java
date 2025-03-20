package comPackage.lld11.filters;

import comPackage.lld11.models.Issue;

import java.util.List;
import java.util.stream.Collectors;

public class EmailFilter extends FilterStrategy{

    private final String email;

    public EmailFilter(String email) {
        this.email = email;
    }

    @Override
    public List<Issue> filter(List<Issue> issues) {
        return issues.stream().filter(issue -> issue.getCustomerEmail().equalsIgnoreCase(email)).collect(Collectors.toList());
    }
}
