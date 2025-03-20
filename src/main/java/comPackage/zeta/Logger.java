package comPackage.zeta;

import comPackage.zeta.models.LogConfig;
import comPackage.zeta.models.LogLevel;
import comPackage.zeta.models.LogMessage;
import comPackage.zeta.models.loglevels.*;

public class Logger implements LoggerI {
    private LogHandler chainHead;
    private final LogConfig logConfig;

    public Logger(LogConfig logConfig) {
        this.logConfig = logConfig;
        setLogHandler();
    }

    private void setLogHandler(){


        LogHandler debugHandler = new DebugLogHandler();
        LogHandler infoLogHandler = new InfoLogHandler();
        LogHandler warnloghandler = new WarnLogHandler();
        LogHandler errorloghandler = new ErrorLogHandler();
        debugHandler.setNext(infoLogHandler);
        infoLogHandler.setNext(warnloghandler);
        warnloghandler.setNext(errorloghandler);

        if(logConfig.getHead()== LogLevel.DEBUG){
            chainHead = debugHandler;
        }
        else if(logConfig.getHead() == LogLevel.INFO){
            chainHead = infoLogHandler;
        }
        else if(logConfig.getHead() == LogLevel.WARN){
            chainHead = warnloghandler;
        }
        else if(logConfig.getHead() == LogLevel.ERROR){
            chainHead = errorloghandler;
        }
        else{
            throw  new IllegalArgumentException("This log level not configured in Logger library!");
        }



    }

    private void logging(LogLevel logLevel,String message){
        LogMessage logMessage = chainHead.handle(logLevel,message);
        logConfig.getLogAppenderMap().get(logLevel).append(logMessage);
    }

    @Override
    public void error(String message) {
        logging(LogLevel.ERROR,message);

    }

   @Override
   public void warn(String message){
       logging(LogLevel.WARN,message);
   }

    @Override
    public void info(String message) {
        logging(LogLevel.INFO,message);
    }

    @Override
    public void debug(String message) {
        logging(LogLevel.DEBUG,message);
    }


}
