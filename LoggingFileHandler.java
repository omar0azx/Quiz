import java.io.IOException;
import java.util.logging.Logger;

public class LoggingFileHandler implements IQuestionAnswerSource {
    private IQuestionAnswerSource questionAnswerSource;
    private final Logger logger;

    public LoggingFileHandler(IQuestionAnswerSource questionAnswerSource, Logger logger2) {
        this.questionAnswerSource = questionAnswerSource;
        this.logger = logger2;
    }

    @Override
    public String[] getQuestions() throws IOException {
        logger.info("Getting questions");
        return questionAnswerSource.getQuestions();
    }

    @Override
    public String getAnswer(int index) throws IOException {
        logger.info("Getting answer for index: " + index);
        return questionAnswerSource.getAnswer(index);
    }
    }
