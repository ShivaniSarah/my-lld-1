package comPackage.lld10.services;

import comPackage.lld10.models.Task;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RemovedTask implements TaskOperationI{
    private final Map<Date, Task> removedTaskMap;

    public RemovedTask() {
        this.removedTaskMap = new HashMap<>();
    }

    @Override
    public void addTask(Task task) {
        removedTaskMap.putIfAbsent(new Date(),task);
    }

    public Map<Date, Task> getRemovedTaskMap() {
        return removedTaskMap;
    }
}
