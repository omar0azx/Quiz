import java.io.IOException;

// IQuestionAnswerSource is an interface that defines the strategy for reading questions and answers
public interface IQuestionAnswerSource {
    String[] getQuestions() throws IOException;

    String getAnswer(int index) throws IOException;
}