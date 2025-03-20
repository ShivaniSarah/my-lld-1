package comPackage.lld3.models;
import java.util.Date;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Task {

    private final Integer taskId;
    private String text;
    private final Date createdDate;
    private Date deadline;
    private String tag;
    private boolean isCompleted;
    private Date completeDate;
    private Date lastModifiedDate;

    Task(Integer id, String text, Date deadline,String tag){
        this.taskId=id;
        this.text=text;
        this.createdDate= new Date();
        this.deadline=deadline;
        this.tag=tag;
    }

    public boolean isTask(Integer id){
        return Objects.equals(this.taskId, id);
    }
    public boolean isCompleted(){
        return isCompleted;
    }


}
