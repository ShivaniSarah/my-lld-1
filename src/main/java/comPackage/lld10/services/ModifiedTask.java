package comPackage.lld10.services;

import comPackage.lld10.models.Task;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ModifiedTask implements TaskOperationI{
    private final Map<Date, Task> modifiedTaskMap;

    public ModifiedTask() {
        this.modifiedTaskMap = new HashMap<>();
    }

    @Override
    public void addTask(Task task) {
        modifiedTaskMap.putIfAbsent(new Date(), task);
    }

    public Map<Date, Task> getModifiedTaskMap() {
        return modifiedTaskMap;
    }
}
