package comPackage.lld9.logappender;

import comPackage.lld9.LogMessage;

public class ConsoleAppender implements LogAppender {
    @Override
    public void append(LogMessage logMessage) {
        System.out.println(logMessage.toString());
    }
}
