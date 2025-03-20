package comPackage.lld10.services;

import comPackage.lld10.models.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;

public class AddedTask implements TaskOperationI{
    private final Map<Date, Task> addedTaskMap;

    public AddedTask() {
        this.addedTaskMap = new HashMap<>();
    }

    @Override
    public void addTask(Task task) {
        addedTaskMap.putIfAbsent(new Date(), task);
    }

    public Map<Date, Task> getAddedTaskMap() {
        return addedTaskMap;
    }
}
