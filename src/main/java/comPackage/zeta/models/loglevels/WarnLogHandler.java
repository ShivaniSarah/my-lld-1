package comPackage.zeta.models.loglevels;

import comPackage.zeta.models.LogLevel;
import comPackage.zeta.models.LogMessage;

public class WarnLogHandler extends LogHandler {

    @Override
    protected boolean canHandle(LogLevel logLevel) {
        return LogLevel.WARN.equals(logLevel);
    }

    @Override
    protected LogMessage buildLogMessage(String message) {
        return getLogMessage(LogLevel.WARN,message);
    }
}
