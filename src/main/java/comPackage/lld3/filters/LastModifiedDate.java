package comPackage.lld3.filters;

import comPackage.lld3.enums.FilterCriteria;
import comPackage.lld3.models.Task;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class LastModifiedDate extends FilterStrategy {
    private Date fromDate;
    private Date toDate;
    public LastModifiedDate(FilterCriteria filterCriteria, Date fromDate, Date toDate){
//        super(filterCriteria);
        this.fromDate = fromDate;
        this.toDate = toDate;
    }
    public List<Task> filter(List<Task> tasks) {
        return tasks.stream()
                .filter(task -> {
                    Date lastModifiedDate = task.getLastModifiedDate();
                    return lastModifiedDate != null && lastModifiedDate.after(fromDate) && lastModifiedDate.before(toDate);
                })
                .collect(Collectors.toList());
    }
}
