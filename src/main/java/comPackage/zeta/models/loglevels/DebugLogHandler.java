package comPackage.zeta.models.loglevels;

import comPackage.zeta.models.LogLevel;
import comPackage.zeta.models.LogMessage;

public class DebugLogHandler extends LogHandler {

    public DebugLogHandler() {
    }

    @Override
    protected LogMessage buildLogMessage(String message) {
        return getLogMessage(LogLevel.DEBUG,message);
    }

    @Override
    protected boolean canHandle(LogLevel logLevel) {
        return LogLevel.DEBUG.equals(logLevel);
    }
}
