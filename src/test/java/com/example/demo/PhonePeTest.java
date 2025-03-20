package com.example.demo;


import comPackage.lld11.models.*;
import comPackage.lld11.services.*;
import comPackage.lld11.strategy.DefaultIssueStrategy;
import comPackage.lld11.strategy.IssueStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PhonePeTest {

    private AgentService agentService;
    private IssueStrategy issueStrategy;
    private IssueService issueService;
    private CustomerService customerService;

    @BeforeEach
    void setup() {
        agentService = new AgentServiceImpl();
        issueStrategy = new DefaultIssueStrategy(agentService);
        issueService = new IssueServiceImpl(issueStrategy, agentService);
        customerService = new CustomerServiceImpl(issueService);
    }

    @Test
    public void testCreateAgent() {
        List<IssueType> issueTypeList = new ArrayList<>();
        issueTypeList.add(IssueType.MUTUAL_FUND);
        issueTypeList.add(IssueType.INSURANCE);
        agentService.addAgent("agent@gmail.com", "Alok", issueTypeList, 5);
        List<Agent> agents = agentService.getAgents();
        Assertions.assertEquals(1, agents.size());
        Assertions.assertEquals("Alok", agents.get(0).getAgentName());
        Assertions.assertEquals("agent@gmail.com", agents.get(0).getEmailId());
        Assertions.assertEquals(2, agents.get(0).getIssueTypeList().size());
        Assertions.assertTrue(agents.get(0).getIssueTypeList().contains(IssueType.MUTUAL_FUND));
        Assertions.assertTrue(agents.get(0).getIssueTypeList().contains(IssueType.INSURANCE));
        Assertions.assertEquals(5, agents.get(0).getQueueSize());
    }

    @Test
    public void testAssignAgent() {
        List<IssueType> alokIssueTypeList = new ArrayList<>();
        alokIssueTypeList.add(IssueType.MUTUAL_FUND);
        alokIssueTypeList.add(IssueType.INSURANCE);
        agentService.addAgent("alok@gmail.com", "Alok", alokIssueTypeList, 5);
        List<IssueType> samayIssueTypeList = new ArrayList<>();
        samayIssueTypeList.add(IssueType.MUTUAL_FUND);
        agentService.addAgent("samay@gmail.com", "Samay", samayIssueTypeList, 2);
        Customer customer = new Customer("1", "Ajay", "ajay@gmail.com");
        Issue issue = customerService.createIssue("e377983", "Insurance Related", "payment in pending state",
                "fix my payment", customer.getEmailId());
        Assertions.assertEquals(Status.OPEN, issue.getStatus());
        issueService.assignIssue(issue.getIssueId());
        Assertions.assertEquals(Status.IN_PROGRESS, issue.getStatus());
        Agent agent = agentService.getAgentById("1");
        Assertions.assertEquals("alok@gmail.com", agent.getEmailId());
        issueService.resolveIssue(issue.getIssueId(), "Insurance payment is completed");
        Assertions.assertEquals(Status.RESOLVED, issue.getStatus());
    }
}
