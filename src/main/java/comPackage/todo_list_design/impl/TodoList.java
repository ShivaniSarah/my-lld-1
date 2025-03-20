package comPackage.lld3.impl;
import comPackage.lld3.enums.FilterCriteria;
import comPackage.lld3.enums.SortCriteria;
import comPackage.lld3.filters.FilterStrategy;
import comPackage.lld3.filters.SortStrategy;
import comPackage.lld3.models.Task;
import comPackage.lld3.services.TodoListIntf;
import lombok.Getter;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public class TodoList implements TodoListIntf {
    private List<Task> tasks;
    private final Integer todoListId;

    TodoList(Integer id){
        this.tasks  = new LinkedList<>();
        this.todoListId = id;
    }

    @Override
    public boolean addTask(Task task){
        return this.tasks.add(task);
    }
    @Override
    public Task getTask(Integer taskId){
        for(Task task: this.tasks){
            if(task.isTask(taskId))
                return task;
        }
        return null;
    }
    @Override
    public boolean removeTask(Integer taskId){
        //TODO: remove from original list and push to a new completed task list
//        return tasks.removeIf(task -> task.isTask(taskId)); // easy way
        Iterator<Task> iterator = this.tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.isTask(taskId)) {
                task.setCompleted(true);
                task.setCompleteDate(new Date());
                iterator.remove();
                return true;
            }
        }
        return false;

    }
    @Override
    public boolean modifyTask(Integer taskId, String text, Date deadline, String tag){
        for (Task task : this.tasks) {
            if (task.isTask(taskId)) {
                if (text != null) {
                    task.setText(text);
                }
                if (deadline != null) {
                    task.setDeadline(deadline);
                }
                if (tag != null){
                    task.setTag(tag);
                }
                task.setLastModifiedDate(new Date());
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Task> listTasks(SortStrategy sortStrategy) {
        return sortStrategy.sort(this.tasks);
    }

    @Override
    public List<Task> listTasks(List<FilterStrategy> filterStrategies, SortStrategy sortStrategies) {
        List<Task> filtered_tasks = this.tasks;
        for(FilterStrategy fs : filterStrategies){
            filtered_tasks = fs.filter(filtered_tasks);
        }
        return sortStrategies.sort(filtered_tasks);
    }

    @Override
    public Map<String, List<Task>> getActivityLog(Date fromDate, Date toDate) {
        List<Task> addedTasks=
        this.tasks.stream()
                .filter(task -> {
                    Date createdDate = task.getCreatedDate();
                    return createdDate != null && createdDate.after(fromDate) && createdDate.before(toDate);
                })
                .collect(Collectors.toList());
        List<Task> modifiedTasks =
                tasks.stream()
                .filter(task -> {
                    Date lastModifiedDate = task.getLastModifiedDate();
                    return lastModifiedDate != null && lastModifiedDate.after(fromDate) && lastModifiedDate.before(toDate);
                })
                .collect(Collectors.toList());
        List<Task> removedTasks =
                tasks.stream()
                        .filter(task -> {
                            Date completeDate = task.getCompleteDate();
                            return completeDate != null && completeDate.after(fromDate) && completeDate.before(toDate);
                        })
                        .collect(Collectors.toList());
        Map<String,List<Task>> mpp= new HashMap<>();
        mpp.put("ADDED_TASKS",addedTasks);
        mpp.put("MODIFIED_TASKS",modifiedTasks);
        mpp.put("REMOVED_TASKS",removedTasks);
        return mpp;
    }

    @Override
    public Map<String, Long> getStatistics(Date fromDate, Date toDate) {
        Long addedTasks=
                this.tasks.stream()
                        .filter(task -> {
                            Date createdDate = task.getCreatedDate();
                            return createdDate != null && createdDate.after(fromDate) && createdDate.before(toDate);
                        })
                        .count();
        Long modifiedTasks =
                tasks.stream()
                        .filter(task -> {
                            Date lastModifiedDate = task.getLastModifiedDate();
                            return lastModifiedDate != null && lastModifiedDate.after(fromDate) && lastModifiedDate.before(toDate);
                        })
                        .count();
        Long removedTasks =
                tasks.stream()
                        .filter(task -> {
                            Date completeDate = task.getCompleteDate();
                            return completeDate != null && completeDate.after(fromDate) && completeDate.before(toDate);
                        })
                        .count();
        Long spilled_tasks =
                tasks.stream()
                        .filter(task -> {
                            Date deadline = task.getDeadline();
                            Date completedDate = task.getCompleteDate();
                            return deadline != null  && completedDate != null
                                    && deadline.after(fromDate) && deadline.before(toDate) && completedDate.after(deadline);
                        })
                        .count();
        Map<String,Long> mpp= new HashMap<>();
        mpp.put("ADDED_TASKS",addedTasks);
        mpp.put("MODIFIED_TASKS",modifiedTasks);
        mpp.put("REMOVED_TASKS",removedTasks);
        mpp.put("SPILLED_TASKS",spilled_tasks);
        return mpp;
    }
}
