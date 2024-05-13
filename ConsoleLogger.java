import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

// ConsoleLogger is an observer that logs events from the LoggingFileHandler
public class ConsoleLogger extends Logger {
    public ConsoleLogger() {
        super("ConsoleLogger", null);
        this.setUseParentHandlers(false);
        this.addHandler(new ConsoleHandler());
    }
}