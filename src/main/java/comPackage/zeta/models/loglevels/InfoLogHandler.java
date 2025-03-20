package comPackage.zeta.models.loglevels;

import comPackage.zeta.models.LogLevel;
import comPackage.zeta.models.LogMessage;

public class InfoLogHandler extends  LogHandler{

    @Override
    protected boolean canHandle(LogLevel logLevel) {
        return LogLevel.INFO.equals(logLevel);
    }

    @Override
    protected LogMessage buildLogMessage(String message) {
        return getLogMessage(LogLevel.INFO,message);
    }
}
