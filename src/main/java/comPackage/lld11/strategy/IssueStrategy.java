package comPackage.lld11.strategy;

import comPackage.lld11.models.Agent;
import comPackage.lld11.models.Issue;

import java.util.Optional;

public interface IssueStrategy {

    Optional<Agent> getAgentForIssue(Issue issue);
}
