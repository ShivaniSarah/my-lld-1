package comPackage.phonepe;

import comPackage.phonepe.models.IssueType;
import comPackage.phonepe.services.*;
import comPackage.phonepe.filters.EmailFilter;
import comPackage.phonepe.filters.FilterStrategy;
import comPackage.phonepe.filters.IssueTypeFilter;
import comPackage.phonepe.models.Customer;
import comPackage.phonepe.models.Issue;
import comPackage.phonepe.services.*;
import comPackage.phonepe.strategy.DefaultIssueStrategy;
import comPackage.phonepe.strategy.IssueStrategy;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String args[]){
        IssueStrategy issueStrategy = new DefaultIssueStrategy();
        IssueService issueService = new IssueServiceImpl();
        AgentService agentService = new AgentServiceImpl(issueService,issueStrategy);
        CustomerService customerService = new CustomerServiceImpl(issueService);

        List<IssueType> alokIssueTypeList = new ArrayList<>();
        alokIssueTypeList.add(IssueType.MUTUAL_FUND);
        alokIssueTypeList.add(IssueType.INSURANCE);
        alokIssueTypeList.add(IssueType.PAYMENT);
        agentService.addAgent("alok@gmail.com", "Alok", alokIssueTypeList, 5);
        List<IssueType> samayIssueTypeList = new ArrayList<>();
        samayIssueTypeList.add(IssueType.MUTUAL_FUND);
        agentService.addAgent("samay@gmail.com", "Samay", samayIssueTypeList, 2);

        Customer customer = new Customer("1", "Ajay", "ajay@gmail.com");
        Customer customer2 = new Customer("2", "Amar", "amar@gmail.com");
        Issue issue = customerService.createIssue("e377983", "Insurance Related", "payment in pending state",
                "fix my payment", customer.getEmailId());
        agentService.assignIssue(issue.getIssueId());
        System.out.println(agentService.viewAgentsWorkHistory());
        agentService.resolveIssue(issue.getIssueId(),"checked all params");
        System.out.println(agentService.viewAgentsWorkHistory());
        Issue issue2 = customerService.createIssue("e37983", "Payment Related", "payment in pending state",
                "fix my payment", customer.getEmailId());
        Issue issue3 = customerService.createIssue("e377983", "Gold Related", "payment in pending state",
                "fix my payment", customer.getEmailId());
        agentService.assignIssue(issue2.getIssueId());
        agentService.assignIssue(issue3.getIssueId());
        System.out.println(agentService.viewAgentsWorkHistory());
        System.out.println(agentService.getPendingMap());
        FilterStrategy filterStrategy = new IssueTypeFilter("Mutual Fund Related");
        ArrayList<FilterStrategy> a = new ArrayList<>();
        a.add(filterStrategy);
        a.add(new EmailFilter("amar@gmail.com"));
        System.out.println(issueService.getIssues(a));
        Issue issue4 = customerService.createIssue("e3793", "Gold Related", "payment in pending state",
                "fix my payment", customer2.getEmailId());
        agentService.assignIssue(issue4.getIssueId());
        Issue issue5 = customerService.createIssue("e3793", "Mutual Fund Related", "payment in pending state",
                "fix my payment", customer2.getEmailId());
        agentService.assignIssue(issue4.getIssueId());
        System.out.println(issueService.getIssues(a));


    }

}
