package comPackage.lld10;

import comPackage.lld10.models.Task;
import comPackage.lld10.services.AddedTask;
import comPackage.lld10.services.ModifiedTask;
import comPackage.lld10.services.RemovedTask;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogController implements LogControllerI{

    private final AddedTask addedTask;
    private final ModifiedTask modifiedTask;
    private final RemovedTask removedTask;


    public LogController() {
        this.addedTask = new AddedTask();
        this.modifiedTask = new ModifiedTask();
        this.removedTask = new RemovedTask();
    }

    @Override
    public void addLog(TaskOps taskOps, Task task) {
        if(taskOps.equals(TaskOps.ADD)) addedTask.addTask(task);
        else if (taskOps.equals(TaskOps.MODIFY)) {
            modifiedTask.addTask(task);
        } else if (taskOps.equals(TaskOps.REMOVE)) {
            removedTask.addTask(task);
        }
    }

    @Override
    public Map<String, Integer> getStatistics(Date startDate, Date endDate) {
        Integer addTaskCount=0;
        Integer modifyTaskCount=0;
        Integer removeTaskCount=0;

       for(Map.Entry<Date,Task> e: addedTask.getAddedTaskMap().entrySet()){
           if(e.getKey().after(startDate) && e.getKey().before(endDate))
               addTaskCount++;
       }

        for(Map.Entry<Date,Task> e: modifiedTask.getModifiedTaskMap().entrySet()){
            if(e.getKey().after(startDate) && e.getKey().before(endDate))
                modifyTaskCount++;
        }
        for(Map.Entry<Date,Task> e: removedTask.getRemovedTaskMap().entrySet()){
            if(e.getKey().after(startDate) && e.getKey().before(endDate))
                removeTaskCount++;
        }

        Map<String,Integer> returnmap = new HashMap<>();
        returnmap.put("ADDED",addTaskCount);
        returnmap.put("MODIFIED",modifyTaskCount);
        returnmap.put("REMOVE",removeTaskCount);
        return returnmap;
    }

    @Override
    public  Map<String, Integer>  getActivityLog(Date startDate, Date endDate, TaskListI taskList) {
        Integer addTaskCount=0;
        Integer completedTaskCount=0;
        Integer spilledTaskCount=0;

        for(Map.Entry<Date,Task> e: addedTask.getAddedTaskMap().entrySet()){
            if(e.getKey().after(startDate) && e.getKey().before(endDate))
                addTaskCount++;
        }

        for(Map.Entry<String,Task> e: taskList.getTaskMap().entrySet()){
            if(e.getValue().getCompletedDate().after(startDate) && e.getValue().getCompletedDate().before(endDate)
            && e.getValue().isCompleted()
            )

                completedTaskCount++;
        }

        for(Map.Entry<String,Task> e: taskList.getTaskMap().entrySet()){
            if(e.getValue().getDeadline().after(startDate) && e.getValue().getDeadline().before(endDate)
                    && !e.getValue().isCompleted()


            )

                spilledTaskCount++;
        }
        Map<String,Integer> returnmap = new HashMap<>();
        returnmap.put("ADDED",addTaskCount);
        returnmap.put("COMPLETED",completedTaskCount);
        returnmap.put("SPILLED",spilledTaskCount);
        return returnmap;

    }
}
