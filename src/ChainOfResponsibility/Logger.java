package ChainOfResponsibility;

abstract public class Logger {
    public static int INFO  = 1;
    public static int WARN  = 2;
    public static int ERROR  = 3;
    Logger nextLogger;
    Logger() {}

    Logger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    abstract void log(int level, String message);

}
