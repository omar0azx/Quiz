import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

public class ConsoleLogger extends Logger {
    public ConsoleLogger() {
        super("ConsoleLogger", null);
        this.setUseParentHandlers(false);
        this.addHandler(new ConsoleHandler());
    }
}