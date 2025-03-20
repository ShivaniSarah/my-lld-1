package comPackage.zeta.models.logappenders;

import comPackage.zeta.models.LogMessage;

public class ConsoleAppender implements LogAppender{
    @Override
    public void append(LogMessage logMessage) {
        if(!logMessage.getContent().isEmpty()){
            System.out.println("writing to console: "+logMessage);
        }
    }
}
