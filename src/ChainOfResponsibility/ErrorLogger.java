package ChainOfResponsibility;

public class ErrorLogger extends Logger {
    public ErrorLogger() {
    }

    void log(int level, String message) {
        if (level == Logger.ERROR) {
            System.out.println("Error: " + message);
        } else if (this.nextLogger != null) {
            this.nextLogger.log(level, message);
        }
    }
}
