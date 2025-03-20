package comPackage.lld11.services;

import comPackage.lld11.models.Agent;
import comPackage.lld11.models.Issue;
import comPackage.lld11.models.IssueType;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class AgentServiceImpl implements AgentService{

    private final Map<String, Agent> agentMap;

    private static final AtomicInteger agentId= new AtomicInteger(0);

    public AgentServiceImpl() {
        this.agentMap = new LinkedHashMap<>();
    }

    @Override
    public void addAgent(String agentEmail, String agentName, List<IssueType> issueTypes, int agentCapacity) {
        int id = agentId.incrementAndGet();
        Agent agent = new Agent(String.valueOf(id), agentName, agentEmail, issueTypes, agentCapacity);
        agentMap.putIfAbsent(agent.getAgentId(), agent);
    }

    @Override
    public List<Issue> viewAgentsWorkHistory(String agentId) {
        Agent agent = agentMap.get(agentId);
        if (Objects.isNull(agent)) {
            throw new RuntimeException("Agent not present " + agentId);
        }
        return agent.getWorkHistory();
    }

    @Override
    public List<Agent> getAgents() {
        return new ArrayList<>(agentMap.values());
    }

    @Override
    public Agent getAgentById(String agentId) {
        return agentMap.get(agentId);
    }

    @Override
    public void markIssueAsResolved(Issue issue) {
        Agent agent = agentMap.get(issue.getAgentId());
        agent.removeIssue(issue);
    }
}
