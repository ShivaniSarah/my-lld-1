package comPackage.zeta.models.loglevels;

import comPackage.zeta.models.LogLevel;
import comPackage.zeta.models.LogMessage;

import java.util.Objects;

public abstract class LogHandler {

    protected LogHandler next;

    public void setNext(LogHandler next){
        this.next = next;
    }

    public LogMessage handle(LogLevel logLevel, String message){
        if(canHandle(logLevel)){
            return buildLogMessage(message);
        }
        else if(Objects.nonNull(this.next)){
            return this.next.handle(logLevel,message);
        }
        return new LogMessage("",0l,null);

//        else{
//            throw new IllegalArgumentException("This log level doesnt exist !");
//        }
    }
    protected LogMessage getLogMessage(LogLevel logLevel, String message){
        return LogMessage.builder().logLevel(logLevel).content(message).timestamp(System.currentTimeMillis()).build();
    }
    protected abstract boolean canHandle(LogLevel logLevel);
    protected abstract LogMessage buildLogMessage(String message);

}
