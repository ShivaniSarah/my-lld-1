package comPackage.lld9.loglevels;

import comPackage.lld9.LogLevel;
import comPackage.lld9.LogMessage;

import java.util.Objects;

public abstract class LogHandler {

    protected LogHandler next;

    public void setNext(LogHandler next) {
        this.next = next;
    }

    public LogMessage handle(LogLevel logLevel, String message){
        if(canHandle(logLevel)){
            return buildLogMessage(message);
        }
        if(Objects.nonNull(this.next)){
            return this.next.handle(logLevel, message);
        }
        throw new IllegalArgumentException("This log level doesnt exist");
    }

    protected LogMessage getLogMessage(LogLevel logLevel, String message) {
        return LogMessage.builder().logLevel(logLevel).message(message)
                .timestamp(System.currentTimeMillis()).build();
    }

    protected abstract boolean canHandle(LogLevel level);
    protected abstract LogMessage buildLogMessage(String message);
}
