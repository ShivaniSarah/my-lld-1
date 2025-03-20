package comPackage.phonepe.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Getter
public class Agent {

    private final String agentId;
    private final String agentName;
    private final String emailId;
    private final List<IssueType> issueTypeList;
    private final Queue<Issue> activeQueue;
    private final Queue<Issue> completedQueue;
    private final int queueSize;

    public Agent(String agentId, String agentName, String emailId, List<IssueType> issueTypeList, int size) {
        this.agentId = agentId;
        this.agentName = agentName;
        this.emailId = emailId;
        this.issueTypeList = issueTypeList;
        this.completedQueue = new LinkedList<>();
        activeQueue = new LinkedList<>();
        queueSize = size;
    }

    public boolean isAbleToTakeIssue(IssueType issueType) {
        return !(activeQueue.size() == queueSize) && issueTypeList.contains(issueType);
    }


    public synchronized void updateIssue(Issue issue, Status status, String resolution) {
        issue.setStatus(status);
        issue.setResolution(resolution);
    }

    public synchronized void assignIssue(Issue issue) {
        issue.setAgentId(agentId);
        this.updateIssue(issue, Status.IN_PROGRESS, "Moving to progress");
        activeQueue.add(issue);
    }

    public synchronized void removeIssue(Issue issue) {
        activeQueue.remove(issue);
        completedQueue.add(issue);
    }

    public List<Issue> getWorkHistory() {
        List<Issue> issues = new ArrayList<>(activeQueue.stream().toList());
        issues.addAll(completedQueue.stream().toList());
        return issues;
    }
}
