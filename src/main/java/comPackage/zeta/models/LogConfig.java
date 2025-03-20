package comPackage.zeta.models;

import comPackage.zeta.models.logappenders.LogAppender;

import java.util.Map;

public class LogConfig {
    private final LogLevel head;
    private final Map<LogLevel, LogAppender> logAppenderMap;

    public LogConfig(LogLevel head, Map<LogLevel, LogAppender> logAppenderMap) {
        this.head = head;
        this.logAppenderMap = logAppenderMap;
    }

    public LogLevel getHead() {
        return head;
    }

    public Map<LogLevel, LogAppender> getLogAppenderMap() {
        return logAppenderMap;
    }
}
