package comPackage.zeta;
import comPackage.zeta.models.LogConfig;
import comPackage.zeta.models.LogLevel;
import comPackage.zeta.models.logappenders.ConsoleAppender;
import comPackage.zeta.models.logappenders.FileAppender;
import comPackage.zeta.models.logappenders.LogAppender;

import java.util.HashMap;
import java.util.Map;

public class LoggingApp {

    public  static  void main(String args[]){
        Map<LogLevel, LogAppender> mapConfig =new HashMap<>();
        mapConfig.put(LogLevel.DEBUG,new ConsoleAppender());
        mapConfig.put(LogLevel.INFO,new FileAppender());
    Logger logger = new Logger(new LogConfig(LogLevel.INFO,mapConfig));
    logger.info("hello");
    logger.debug("hello1");

    }
}
