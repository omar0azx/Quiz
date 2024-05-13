// public class Main {
//     public static void main(String[] args) {
//         new W_Start();
//     }
// }

import javax.swing.JFrame;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        // Create a new instance of the FileHandler
        FileHandler fileHandler = FileHandler.getInstance();

        // Create a new instance of the QuestionAnswerSourceAdapter, which adapts the
        // FileHandler to the IQuestionAnswerSource interface
        IQuestionAnswerSource questionAnswerSource = new QuestionAnswerSourceAdapter(fileHandler);

        // Create a new instance of the ConsoleLogger, which will log events from the
        // LoggingFileHandler
        Logger logger = new ConsoleLogger();

        // Create a new instance of the LoggingFileHandler, which maintains a list of
        // observers and notifies them when its state changes
        IQuestionAnswerSource decoratedQuestionAnswerSource = new LoggingFileHandler(questionAnswerSource, logger);

        // Create a new instance of the Start window, passing in the decorated
        // QuestionAnswerSource
        JFrame startWindow = WindowFactory.createWindow(WindowFactory.WindowType.START, decoratedQuestionAnswerSource);

        // Set the window to be visible
        startWindow.setVisible(true);
    }

}
