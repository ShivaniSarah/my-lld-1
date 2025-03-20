package comPackage.zeta.models.logappenders;

import comPackage.zeta.models.LogMessage;

public class DatabaseAppender implements LogAppender{
    @Override
    public void append(LogMessage logMessage) {
        // writing to a database
    }
}
