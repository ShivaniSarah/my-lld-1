package comPackage.lld9;

import comPackage.lld9.logappender.ConsoleAppender;

public class LoggingFrameworkApp1 {

    public static  void main(String args[]){
        Logger.initialize(new LogConfig(new ConsoleAppender(),false));
        Logger logger = Logger.getInstance();
        logger.debug("sdhsjds,d");
        logger.error("sdh,d");
        logger.setlogAppender(new FileAppender("hello.txt"));
        logger.info("tyy");
        logger.setAppendAll(true);
        logger.addAppender(new FileAppender("hello.txt"));
        logger.info("dsasasda");
        logger.error("adsdada");
        logger.fatal("csd");
        LogAppender app1 = new FileAppender("hello1.txt");
        logger.addAppender(app1);
        logger.info("dsfvvd");
        logger.removeAppender(app1);
        logger.fatal("wadsdfds");
    }
}
