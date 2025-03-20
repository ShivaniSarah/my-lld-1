package comPackage.lld3.filters;

import comPackage.lld3.enums.FilterCriteria;
import comPackage.lld3.enums.SortCriteria;
import comPackage.lld3.models.Task;
import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
public class SortStrategy {
    private FilterCriteria filterCriteria;
    private SortCriteria sortCriteria;

    public SortStrategy(FilterCriteria filterCriteria, SortCriteria sortCriteria){
        this.filterCriteria = filterCriteria;
        this.sortCriteria = sortCriteria;
    }

    public List<Task> sort(List<Task> tasks){
        Stream<Task> filteredTasks = tasks.stream();
        Function<Task, Comparable> keyExtractor;
        switch (filterCriteria) {
            case COMPLETED_TASKS:
                keyExtractor = Task::getCompleteDate;
                break;
            case TAGGED_TASKS:
                keyExtractor = Task::getTag;
                break;
            case CREATED_DATE:
                keyExtractor = Task::getCreatedDate;
                break;
            case DEADLINE:
                keyExtractor = Task::getDeadline;
                break;
            default:
                throw new IllegalArgumentException("Invalid filter criteria");
        }
        Comparator<Task> comparator = Comparator.comparing(keyExtractor, Comparator.nullsLast(Comparator.naturalOrder()));
        if (Objects.equals(sortCriteria, SortCriteria.DESC)) {
            comparator = Comparator.nullsLast(comparator.reversed());
        }

        filteredTasks = filteredTasks.sorted(comparator);

        return filteredTasks.collect(Collectors.toList());
    }
}
