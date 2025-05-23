package comPackage.phonepe.filters;

import comPackage.phonepe.models.Issue;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public abstract class FilterStrategy {

    public abstract List<Issue> filter(List<Issue> issues);
}
