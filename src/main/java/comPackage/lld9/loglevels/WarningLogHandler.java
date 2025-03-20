package comPackage.lld9.loglevels;

import comPackage.lld9.LogLevel;
import comPackage.lld9.LogMessage;

public class WarningLogHandler extends LogHandler{

    @Override
    protected LogMessage buildLogMessage(String message) {
        return getLogMessage(LogLevel.WARNING, message);
    }

        @Override
        protected boolean canHandle(LogLevel level) {
            return level==LogLevel.WARNING;
        }


}
