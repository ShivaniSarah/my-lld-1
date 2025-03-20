package comPackage.lld10;

import comPackage.lld10.models.Task;

import java.util.Map;

public interface TaskListI {
    void addTask(Task task);
    void modifyTask(String taskId,Task task);
    void removeTask(String taskId);
    Task getTask(String taskId);
    Map<String, Task> getTaskMap();
}
