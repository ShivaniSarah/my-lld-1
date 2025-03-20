package comPackage.lld9.loglevels;

import comPackage.lld9.LogLevel;
import comPackage.lld9.LogMessage;

public class FatalLogHandler extends LogHandler{
    @Override
    protected LogMessage buildLogMessage(String message) {
        return getLogMessage(LogLevel.FATAL, message);
    }

    @Override
    protected boolean canHandle(LogLevel level) {
        return level==LogLevel.FATAL;
    }


}
