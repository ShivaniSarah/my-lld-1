package comPackage.phonepe.services;

import comPackage.phonepe.models.Issue;
import comPackage.phonepe.models.IssueType;
import comPackage.phonepe.models.Agent;
import comPackage.phonepe.models.Status;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public interface AgentService {

    Agent addAgent(String agentEmail, String agentName , List<IssueType> issueTypes, int capacity);
    List<Issue> viewAgentsWorkHistory(String agentId);
    Map<String,List<Issue>> viewAgentsWorkHistory();
    List<Agent> getAgents();
    void assignIssue(String issueId);
    void updateIssue(String issueId, Status status, String resolution);
    void resolveIssue(String issueId, String resolution);
    Agent getAgentById(String agentId);
    Queue<Issue> getPendingMap();
}
