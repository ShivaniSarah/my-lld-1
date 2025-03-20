package comPackage.lld10;

import comPackage.lld10.models.Task;
import comPackage.lld10.strategy.FilterCriteria;
import comPackage.lld10.strategy.SortCriteria;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface TaskControllerI {

    void addTask(Task task);
    Task getTask(String taskId);
    void modifyTask(String taskId,Task task);
    void removeTask(String taskId);
    List<Task> listTasks(String filterField, Object filterValue, String sortField, String sortValue);
    Map<String,Integer> getStatistics(Date startDate, Date endDate);
    Map<String,Integer> getActivityLog(Date startDate, Date endDate);
    void markCompleted(String taskId);
}
