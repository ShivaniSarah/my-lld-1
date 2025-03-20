package comPackage.lld10;

import comPackage.lld10.models.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskList implements TaskListI{
    private final Map<String, Task> taskMap;

    public TaskList() {
        this.taskMap = new HashMap<>();
    }

    @Override
    public void addTask(Task task) {
        taskMap.putIfAbsent(task.getTaskId(),task);
    }

    @Override
    public void modifyTask(String taskId, Task task) {
        taskMap.put(taskId,task);
    }

    @Override
    public void removeTask(String taskId) {
        taskMap.remove(taskId);
    }

    @Override
    public Task getTask(String taskId) {
        return taskMap.get(taskId);
    }

    public Map<String, Task> getTaskMap() {
        return taskMap;
    }

    public List< Task> getTasks() {
        return taskMap.values().stream().toList();
    }
}
