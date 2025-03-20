package comPackage.lld10.strategy;

import comPackage.lld10.models.Task;

import java.util.List;
import java.util.Objects;

public class SortCriteria {

    public List<Task> sort(List<Task> tasks, String sortField,String sortValue){
        boolean ascending = (sortValue.equals("ASC"))? true : false;
        if (Objects.nonNull(sortField) && Objects.nonNull(sortValue)) {
            tasks.sort((task1, task2) -> compareTasks(task1, task2, sortField, ascending));
        }

        return tasks;
    }

    private int compareTasks(Task task1, Task task2, String sortField, boolean ascending) {
        int comparison;

        switch (sortField) {
            case "tag":
                comparison = task1.getTag().compareTo(task2.getTag());
                break;
            case "completedDate":
                comparison = task1.getCompletedDate().compareTo(task2.getCompletedDate());
                break;
            case "deadline":
                comparison = task1.getDeadline().compareTo(task2.getDeadline());
                break;
            default:
                throw new IllegalArgumentException("Invalid sort field: " + sortField);
        }

        return ascending ? comparison : -comparison;
    }
}
