package comPackage.lld3.filters;

import comPackage.lld3.enums.FilterCriteria;
import comPackage.lld3.enums.SortCriteria;
import comPackage.lld3.models.Task;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
public class TagFilter extends FilterStrategy {
    String tag;
    public TagFilter(FilterCriteria filterCriteria, String tag){
        super(filterCriteria);
        this.tag = tag;
    }
    public List<Task> filter(List<Task> tasks){
        return  tasks.stream().filter(task -> Objects.equals(task.getTag(),this.tag))
                .collect(Collectors.toList());
    }
}
