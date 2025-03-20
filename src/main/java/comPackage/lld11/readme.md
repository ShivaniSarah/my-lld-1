PhonePe processes a vast number of transactions every day, wherein some transactions may fail (enter a FAILED state) or remain in a PENDING state due to various reasons such as bank or NPCI issues, or internal PhonePe errors. To handle such cases efficiently, a resolution system is needed, where customers can log their unsuccessful transactions and raise complaints against them.
The system must categorize customer issues into several types, such as payment-related, mutual fund-related, gold-related, or insurance-related. Different customer service agents will have their specific expertise based on the issue type, whom the system will assign the issues by marking them waiting in case all agents are busy.

The customer service agents can work on one issue at a time and update its status, and once it is resolved, the agent will receive another issue.

Customers can log a complaint against any unsuccessful transaction.
Customer Service Agents can search for customer issues with issue ID or customer details (email).
Agents can view their assigned issues and mark them resolved once they are resolved.
System should assign the issue to agents based on an assigning strategy.
System should allow the admin to onboard new agents.
System should allow the admin to view the agent's work history.

Your solution should implement the following functions. Feel free to use the representation for objects you deem fit for the problem and the provided use cases. The functions are ordered in the decreasing order of importance (highest to lowest). We understand that you may not be able to complete the implementation for all the functions listed here. So try to implement them in the order in which they are declared down below.