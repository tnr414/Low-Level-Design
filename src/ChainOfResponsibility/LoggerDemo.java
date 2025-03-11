package ChainOfResponsibility;

public class LoggerDemo {
    public static void main(String[] args) {
        Logger logger = new InfoLogger(new WarnLogger(new ErrorLogger()));

        logger.log(Logger.INFO, "Success");
        logger.log(Logger.WARN, "You should not use this");
        logger.log(Logger.ERROR, "Got an Error");
    }
}
