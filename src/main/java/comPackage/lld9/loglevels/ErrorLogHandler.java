package comPackage.lld9.loglevels;

import comPackage.lld9.LogLevel;
import comPackage.lld9.LogMessage;

public class ErrorLogHandler extends LogHandler{

    @Override
    protected LogMessage buildLogMessage(String message) {
        return getLogMessage(LogLevel.ERROR, message);
    }

    @Override
    protected boolean canHandle(LogLevel level) {
        return level==LogLevel.ERROR;
    }


}
