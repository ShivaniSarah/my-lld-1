package comPackage.lld10;

import comPackage.lld10.models.Task;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface LogControllerI {
    void addLog(TaskOps taskOps, Task task);
    Map<String, Integer> getStatistics(Date startDate, Date endDate);
    Map<String, Integer>  getActivityLog(Date startDate, Date endDate, TaskListI tasklist);
}
