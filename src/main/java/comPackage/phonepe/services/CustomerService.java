package comPackage.phonepe.services;

import comPackage.phonepe.models.Issue;

public interface CustomerService {
    Issue createIssue(String transactionId, String issueType, String subject, String description, String email);
}
