package comPackage.lld9;

import comPackage.lld9.logappender.LogAppender;
import comPackage.lld9.loglevels.*;

import java.util.Objects;


public class Logger {
    private static Logger instance;
    private final LogConfig logConfig;
    private final LogHandler chainHead;
    private final LogObserver logObserver;

    private Logger(LogConfig logConfig) {

        this.chainHead = initializeLogHandler();
        this.logConfig = logConfig;
        this.logObserver = new LogObserver();
        logObserver.registerAppender(logConfig.getLogAppender());

    }
    private LogHandler initializeLogHandler(){
        LogHandler debugLogHandler = new DebugLogHandler();
        LogHandler infoLogHandler= new InfoLogHandler();
        LogHandler warningLogHandler = new WarningLogHandler();
        LogHandler errorLogHandler = new ErrorLogHandler();
        LogHandler fatalLogHandler = new FatalLogHandler();

        debugLogHandler.setNext(infoLogHandler);
        infoLogHandler.setNext(warningLogHandler);
        warningLogHandler.setNext(errorLogHandler);
        errorLogHandler.setNext(fatalLogHandler);
        return debugLogHandler;
    }

    public static synchronized Logger getInstance(LogConfig logConfig) { // singleton pattern
        if(Objects.nonNull(instance))
            return instance;
        return new Logger(logConfig);
    }

   public void addAppender(LogAppender logAppender){
        logObserver.registerAppender(logAppender);
   }

    public void removeAppender(LogAppender logAppender){
        logObserver.removeAppender(logAppender);
    }

    public void setAppendAll(boolean isAppendAll){
        logConfig.setAppendAll(isAppendAll);
    }

    public void setlogAppender(LogAppender logAppender){
        logConfig.setLogAppender(logAppender);
    }

    private void log(LogLevel logLevel, String message ){
        LogMessage logMessage = chainHead.handle(logLevel,new LogMessage(message));
        if( !logConfig.isAppendAll() && Objects.nonNull(logConfig.getLogAppender()))
            logObserver.appendOne(logConfig.getLogAppender(),logMessage);
        else if(logConfig.isAppendAll()){
            logObserver.appendAll(logMessage);
        } else {
            throw new IllegalArgumentException("LogAppender is null");
        }
    }

    public void debug(String message) {
        log(LogLevel.DEBUG,message);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void warning(String message) {
        log(LogLevel.WARNING, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public void fatal(String message) {
        log(LogLevel.FATAL, message);
    }

}
