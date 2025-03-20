package comPackage.lld9;

import comPackage.lld9.logappender.LogAppender;

public class LogConfig {
    private LogAppender logAppender;
    private boolean appendAll;

    public LogConfig(LogAppender logAppender, boolean appendAll) {
        this.logAppender = logAppender;
        this.appendAll = appendAll;
    }

    public LogAppender getLogAppender() {
        return logAppender;
    }

    public boolean isAppendAll() {
        return appendAll;
    }

    public void setLogAppender(LogAppender logAppender) {
        this.logAppender = logAppender;
    }

    public void setAppendAll(boolean appendAll) {
        this.appendAll = appendAll;
    }

}
