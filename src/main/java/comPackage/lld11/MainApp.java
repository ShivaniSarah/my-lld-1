package comPackage.lld11;

import comPackage.lld11.filters.EmailFilter;
import comPackage.lld11.filters.FilterStrategy;
import comPackage.lld11.models.Customer;
import comPackage.lld11.models.Issue;
import comPackage.lld11.models.IssueType;
import comPackage.lld11.services.*;
import comPackage.lld11.strategy.DefaultIssueStrategy;
import comPackage.lld11.strategy.IssueStrategy;

import java.util.ArrayList;
import java.util.List;
//TODO
// keep strategy in agentservice
// do for all work agents
// keep issueservice in customer and agent
// concurrency
public class MainApp {
    public static void main(String args[]){

        AgentService agentService = new AgentServiceImpl();
        List<IssueType> alokIssueTypeList = new ArrayList<>();
        alokIssueTypeList.add(IssueType.MUTUAL_FUND);
        alokIssueTypeList.add(IssueType.INSURANCE);
        agentService.addAgent("alok@gmail.com", "Alok", alokIssueTypeList, 5);
        List<IssueType> samayIssueTypeList = new ArrayList<>();
        samayIssueTypeList.add(IssueType.MUTUAL_FUND);
        agentService.addAgent("samay@gmail.com", "Samay", samayIssueTypeList, 2);
        IssueStrategy issueStrategy = new DefaultIssueStrategy(agentService);
        IssueService issueService = new IssueServiceImpl(issueStrategy, agentService);
        CustomerService customerService = new CustomerServiceImpl(issueService);
        Customer customer = new Customer("1", "Ajay", "ajay@gmail.com");
        Issue issue = customerService.createIssue("e377983", "Insurance Related", "payment in pending state",
                "fix my payment", customer.getEmailId());
        issueService.assignIssue(issue.getIssueId());
        System.out.println(agentService.getAgents());
        FilterStrategy filterStrategy = new EmailFilter("ajay123@gmail.com");
        ArrayList<FilterStrategy> a = new ArrayList<>();
        a.add(filterStrategy);
        System.out.println(issueService.getIssues(a));

    }

}
