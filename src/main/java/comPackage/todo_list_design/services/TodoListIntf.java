package comPackage.lld3.services;
import comPackage.lld3.filters.FilterStrategy;
import comPackage.lld3.filters.SortStrategy;
import comPackage.lld3.models.Task;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import comPackage.lld3.enums.FilterCriteria;
import comPackage.lld3.enums.SortCriteria;

public interface TodoListIntf {
    public boolean addTask(Task task);
    public Task getTask(Integer taskId);
    public boolean removeTask(Integer taskId);
    public boolean modifyTask(Integer taskId, String text, Date deadline, String tag);
    public List<Task> listTasks(SortStrategy sortStrategy);
    public List<Task> listTasks(List<FilterStrategy> filterStrategies, SortStrategy sortStrategy);
    public Map<String, Long> getStatistics(Date fromDate, Date toDate);
    public Map<String, List<Task>> getActivityLog(Date fromDate, Date toDate);
}
