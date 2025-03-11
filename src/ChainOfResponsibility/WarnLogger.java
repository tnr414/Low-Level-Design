package ChainOfResponsibility;

public class WarnLogger extends Logger{
    public WarnLogger(Logger nextLogger) {
        super(nextLogger);
    }

    void log(int level, String message) {
        if (level == Logger.WARN) {
            System.out.println("Warning: " + message);
        } else if (this.nextLogger != null) {
            this.nextLogger.log(level, message);
        }
    }
}
