package comPackage.lld9;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class LogMessage{

    private LogLevel logLevel;
    private String message;
    private final long timestamp;

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public String getMessage() {
        return message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "[ "+logLevel+" ] "+timestamp+" - "+message;
    }

    public void setLogLevel(LogLevel logLevel){
        this.logLevel = logLevel;
    }

    public void addMessage(String message) {
        this.message+= " - "+message;
    }
}
