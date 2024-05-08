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
        FileHandler fileHandler = FileHandler.getInstance();
        IQuestionAnswerSource questionAnswerSource = new QuestionAnswerSourceAdapter(fileHandler);
        Logger logger = new ConsoleLogger(); // Or any other logger implementation
        IQuestionAnswerSource decoratedQuestionAnswerSource = new LoggingFileHandler(questionAnswerSource, logger);

        JFrame startWindow = WindowFactory.createWindow(WindowFactory.WindowType.START, decoratedQuestionAnswerSource);
        startWindow.setVisible(true);
    }

}
