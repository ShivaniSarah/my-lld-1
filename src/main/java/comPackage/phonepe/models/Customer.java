package comPackage.phonepe.models;

import lombok.Getter;

@Getter
public class Customer {
    private final String customerId;
    private final String customerName;
    private final String emailId;

    public Customer(String customerId, String customerName, String emailId) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.emailId = emailId;
    }
}
