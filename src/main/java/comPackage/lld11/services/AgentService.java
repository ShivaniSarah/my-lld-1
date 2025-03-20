package comPackage.lld11.services;

import comPackage.lld11.models.Agent;
import comPackage.lld11.models.Issue;
import comPackage.lld11.models.IssueType;

import java.util.List;

public interface AgentService {

    void addAgent(String agentEmail, String agentName , List<IssueType> issueTypes, int capacity);
    List<Issue> viewAgentsWorkHistory(String agentId);
    List<Agent> getAgents();
    Agent getAgentById(String agentId);

    void markIssueAsResolved(Issue issue);
}
