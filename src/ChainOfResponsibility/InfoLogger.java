package ChainOfResponsibility;

public class InfoLogger extends Logger {
    public InfoLogger(Logger nextLogger) {
        super(nextLogger);
    }

    @Override
    void log(int level, String message) {
        if (level == Logger.INFO) {
            System.out.println("Info: " + message);
        } else if (this.nextLogger != null) {
            this.nextLogger.log(level, message);
        }
    }
}
