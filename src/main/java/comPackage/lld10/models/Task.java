package comPackage.lld10.models;

import java.util.Date;

public class Task {

    private final String taskId;
    private final String taskName;
    private final String content;
    private final Date deadline;
    private final String tag;
    private  boolean isCompleted;
    private  Date completedDate;

    public Task(String taskId, String taskName, String content, Date deadline, String tag) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.content = content;
        this.deadline = deadline;
        this.tag = tag;
        this.isCompleted = false;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    public String getContent() {
        return content;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public Date getDeadline() {
        return deadline;
    }

    public String getTag() {
        return tag;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
    }
}
