package comPackage.lld9;

import comPackage.lld9.logappender.LogAppender;

import java.util.ArrayList;
import java.util.List;

public class LogObserver {

    private final List<LogAppender> logAppenderList;

    public LogObserver() {
        logAppenderList = new ArrayList<>();
    }

    public void registerAppender(LogAppender logAppender){
        logAppenderList.add(logAppender);
    }

    public void removeAppender(LogAppender logAppender){
        logAppenderList.remove(logAppender);
    }

    public void appendOne(LogAppender logAppender, LogMessage logMessage){
        logAppender.append(logMessage);
    }

    public void appendAll(LogMessage logMessage){
        //logAppenderList.forEach(la -> la.append(logMessage));
        for(LogAppender la : logAppenderList){
            la.append(logMessage);
        }
    }

}
