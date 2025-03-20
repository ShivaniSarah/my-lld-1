package comPackage.lld11.models;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Issue {

    private final String issueId;
    private final String transactionId;
    private final String subject;
    private final String description;
    private final IssueType issueType;
    private final String customerEmail;
    @Setter
    private Status status;
    @Setter
    private String resolution;
    @Setter
    private String agentId;

    public Issue(String issueId, String transactionId, String subject, String description, IssueType issueType, String customerEmail) {
        this.issueId = issueId;
        this.transactionId = transactionId;
        this.subject = subject;
        this.description = description;
        this.issueType = issueType;
        this.customerEmail = customerEmail;
        status = Status.OPEN;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "issueId='" + issueId + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", subject='" + subject + '\'' +
                ", description='" + description + '\'' +
                ", issueType=" + issueType +
                ", customerEmail='" + customerEmail + '\'' +
                ", status=" + status +
                ", resolution='" + resolution + '\'' +
                ", agentId='" + agentId + '\'' +
                '}';
    }
}
