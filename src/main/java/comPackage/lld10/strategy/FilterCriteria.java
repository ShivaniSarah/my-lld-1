package comPackage.lld10.strategy;

import comPackage.lld10.models.Task;

import java.util.List;
import java.util.stream.Collectors;

public class FilterCriteria {

    private boolean matchesFilter(Task task, String filterField, Object filterValue) {
        switch (filterField) {
            case "tag":
                return task.getTag().equals(filterValue);
            case "completedDate":
                return task.getCompletedDate().equals(filterValue);
            case "deadline":
                return task.getDeadline().equals(filterValue);
            default:
                throw new IllegalArgumentException("Invalid filter field: " + filterField);
        }
    }
    public List<Task> filter(List<Task> tasks, String filterField, Object filterValue){
        return tasks.stream()
                .filter(task -> matchesFilter(task, filterField, filterValue))
                .collect(Collectors.toList());
    }
}
