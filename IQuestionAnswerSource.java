import java.io.IOException;

public interface IQuestionAnswerSource {
    String[] getQuestions() throws IOException;
    String getAnswer(int index) throws IOException;
}
