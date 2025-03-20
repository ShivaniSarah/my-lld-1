package comPackage.lld11.services;

import comPackage.lld11.models.Issue;

public interface CustomerService {
    Issue createIssue(String transactionId, String issueType, String subject, String description, String email);
}
