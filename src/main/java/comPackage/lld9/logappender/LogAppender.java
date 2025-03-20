package comPackage.lld9.logappender;

import comPackage.lld9.LogMessage;

public interface LogAppender {
    void append(LogMessage logMessage);
}
