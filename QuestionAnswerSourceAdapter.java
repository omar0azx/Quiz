import java.io.IOException;

//create a QuestionAnswerSourceAdapter class to adapt the existing FileHandler to the IQuestionAnswerSource interface:

public class QuestionAnswerSourceAdapter implements IQuestionAnswerSource {
    private FileHandler fileHandler;

    public QuestionAnswerSourceAdapter(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    @Override
    public String[] getQuestions() throws IOException {
        return fileHandler.QuestionsReader();
    }

    @Override
    public String getAnswer(int index) throws IOException {
        return fileHandler.AnswersReader(index);
    }
}