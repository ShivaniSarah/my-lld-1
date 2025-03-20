package comPackage.zeta.models.logappenders;

import comPackage.zeta.models.LogMessage;

public interface LogAppender {
    public void append(LogMessage logMessage);
}
