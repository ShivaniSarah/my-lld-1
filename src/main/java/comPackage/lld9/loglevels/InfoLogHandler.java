package comPackage.lld9.loglevels;

import comPackage.lld9.LogLevel;
import comPackage.lld9.LogMessage;

public class InfoLogHandler extends LogHandler {
    @Override
    protected LogMessage buildLogMessage(String message) {
        return getLogMessage(LogLevel.INFO, message);
    }

    @Override
    protected boolean canHandle(LogLevel level) {
        return level==LogLevel.INFO;
    }
}
