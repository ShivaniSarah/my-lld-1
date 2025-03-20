package comPackage.zeta.models;


import lombok.Builder;

@Builder
public class LogMessage {

    private  String content;
    private long timestamp;
    private  LogLevel logLevel;

    public LogMessage(String content, long timestamp, LogLevel logLevel) {
        this.content = content;
        this.timestamp = timestamp;
        this.logLevel = logLevel;
    }

    public String getContent() {
        return content;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    @Override
    public String toString() {
        return "LogMessage{" +
                "content='" + content + '\'' +
                ", timestamp=" + timestamp +
                ", logLevel=" + logLevel +
                '}';
    }
}
