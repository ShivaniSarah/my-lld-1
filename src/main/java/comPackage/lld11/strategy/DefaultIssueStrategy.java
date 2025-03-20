package comPackage.lld11.strategy;

import comPackage.lld11.models.Agent;
import comPackage.lld11.models.Issue;
import comPackage.lld11.services.AgentService;

import java.util.List;
import java.util.Optional;

public class DefaultIssueStrategy implements IssueStrategy{

    private final AgentService agentService;

    public DefaultIssueStrategy(AgentService agentService) {
        this.agentService = agentService;
    }

    @Override
    public Optional<Agent> getAgentForIssue(Issue issue) {
        List<Agent> agents = agentService.getAgents();
        return agents.stream().filter(agent -> agent.isAbleToTakeIssue(issue.getIssueType())).findFirst();
    }
}
