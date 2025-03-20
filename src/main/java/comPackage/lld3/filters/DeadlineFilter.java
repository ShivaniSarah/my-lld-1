package comPackage.lld3.filters;

import comPackage.lld3.enums.FilterCriteria;
import comPackage.lld3.enums.SortCriteria;
import comPackage.lld3.models.Task;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class DeadlineFilter extends FilterStrategy {
    private Date fromDate;
    private Date toDate;
    public DeadlineFilter(FilterCriteria filterCriteria, Date fromDate, Date toDate){
//        super(filterCriteria);
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public List<Task> filter(List<Task> tasks) {
        return tasks.stream()
                .filter(task -> {
                    Date deadline = task.getDeadline();
                    return deadline != null && deadline.after(fromDate) && deadline.before(toDate);
                })
                .collect(Collectors.toList());
    }
}
