package comPackage.phonepe.strategy;

import comPackage.phonepe.models.IssueType;
import comPackage.phonepe.models.Agent;

import java.util.List;
import java.util.Optional;

public interface IssueStrategy {

    Optional<Agent> getAgentForIssue(IssueType issueType, List<Agent> agents);
}
