package comPackage.lld10;

import comPackage.lld10.models.Task;
import comPackage.lld10.strategy.FilterCriteria;
import comPackage.lld10.strategy.SortCriteria;

import java.util.*;

public class TaskController implements TaskControllerI{
    private final LogControllerI logController;
    private final TaskListI taskList;
    private final FilterCriteria filterCriteria;
    private final SortCriteria sortCriteria;
    public TaskController() {
        this.logController = new LogController();
        this.taskList = new TaskList();
        this.filterCriteria = new FilterCriteria();
        this.sortCriteria = new SortCriteria();
    }

    @Override
    public void addTask(Task task) {
        taskList.addTask(task);
        logController.addLog(TaskOps.ADD,task);
    }

    @Override
    public Task getTask(String taskId) {
        return null;
    }

    @Override
    public void modifyTask(String taskId, Task task) {
        taskList.modifyTask(taskId,task);
        logController.addLog(TaskOps.MODIFY,task);
    }

    @Override
    public void removeTask(String taskId) {

        logController.addLog(TaskOps.REMOVE,taskList.getTask(taskId));
        taskList.removeTask(taskId);
    }

    @Override
    public void markCompleted(String taskId) {
        taskList.getTask(taskId).setCompleted(true);
        taskList.getTask(taskId).setCompletedDate(new Date());
//        taskList.getTaskMap().get(taskId).setCompleted(true);
//        taskList.getTaskMap().get(taskId).setCompletedDate(new Date());
    }

    @Override
    public List<Task> listTasks(String filterField, Object filterValue, String sortField, String sortValue) {
        //TODO : check that from previous code
        List<Task> filteredTasks = new ArrayList<>(taskList.getTaskMap().values());
        if (Objects.nonNull(filterField) && Objects.nonNull(filterValue))
            filteredTasks = filterCriteria.filter(filteredTasks, filterField, filterValue );
         if (Objects.nonNull(sortField) && Objects.nonNull(sortValue)){
            filteredTasks = sortCriteria.sort(filteredTasks, sortField, sortValue );
        }
        return  filteredTasks;


    }

    @Override
    public Map<String, Integer> getStatistics(Date startDate, Date endDate) {
        return logController.getStatistics(startDate,endDate);
    }

    @Override
    public Map<String, Integer> getActivityLog(Date startDate, Date endDate) {
        return logController.getActivityLog(startDate,endDate,taskList);
    }
}
