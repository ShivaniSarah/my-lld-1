package comPackage.lld3.filters;
import comPackage.lld3.enums.FilterCriteria;
import comPackage.lld3.enums.SortCriteria;
import comPackage.lld3.models.Task;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public abstract class FilterStrategy {
//    protected FilterCriteria filterCriteria;

    public FilterStrategy() {
//        this.filterCriteria = filterCriteria;
    }
    public abstract List<Task> filter(List<Task> tasks);
}
