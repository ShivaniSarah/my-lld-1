package comPackage.lld3.filters;

import comPackage.lld3.enums.FilterCriteria;
import comPackage.lld3.enums.SortCriteria;
import comPackage.lld3.models.Task;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CompletedFilter extends FilterStrategy {
    private boolean isCompleted;
    public CompletedFilter(FilterCriteria filterCriteria, boolean isCompleted){
        super(filterCriteria);
        this.isCompleted = isCompleted;
    }
    public List<Task> filter(List<Task> tasks){
       return  tasks.stream().filter(Task::isCompleted).collect(Collectors.toList());
    }
}
