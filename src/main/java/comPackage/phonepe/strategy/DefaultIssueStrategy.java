package comPackage.phonepe.strategy;

import comPackage.phonepe.models.IssueType;
import comPackage.phonepe.models.Agent;

import java.util.List;
import java.util.Optional;

public class DefaultIssueStrategy implements IssueStrategy {

    @Override
    public Optional<Agent> getAgentForIssue(IssueType issueType, List<Agent> agents) {
        return agents.stream().filter(agent -> agent.isAbleToTakeIssue(issueType)).findFirst();
    }
}
