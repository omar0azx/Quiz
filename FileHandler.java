import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    // Single instance of FileHandler, initially null
    private static FileHandler instance;

    /**
     * Private constructor to prevent instantiation.
     */
    private FileHandler() {
    }

    /**
     * Provides the global point of access to the FileHandler instance.
     * 
     * @return the single instance of FileHandler
     */
    public static synchronized FileHandler getInstance() {
        if (instance == null) {
            instance = new FileHandler();
        }
        return instance;
    }

    /**
     * Method will be called by W_Add
     * 
     * @param txtQuestion takes the question from W_Add
     * @param txtAnswers  takes the answer from W_Add
     */
    public static void FWriter(JTextField txtQuestion, JTextArea txtAnswers) throws IOException {
        // Use BufferedWriter for writing text with UTF-8 encoding
        try (Writer questionWriter = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("Questions.dat", true), StandardCharsets.UTF_8));
                Writer answerWriter = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream("Answers.dat", true), StandardCharsets.UTF_8))) {

            if (!txtQuestion.getText().isBlank() && !txtAnswers.getText().isBlank()) {
                questionWriter.write(txtQuestion.getText() + "\n"); // Add newline to separate entries
                answerWriter.write(txtAnswers.getText() + "\n");
                JOptionPane.showMessageDialog(null, "Save successful");
            } else {
                JOptionPane.showMessageDialog(null, "Wrong input");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occurred during file writing");
            throw e;
        }
    }

    /**
     * This method gets called by W_Quiz
     * 
     * @return An array of string of Questions.dat
     * @throws IOException in case the file is empty or not found
     */
    public static String[] QuestionsReader() throws IOException {
        List<String> questions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream("Questions.dat"), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                questions.add(line);
            }
        }
        return questions.toArray(new String[0]);
    }

    /**
     * This method gets called by W_SelectedQuiz
     * 
     * @param selected the index of the selected question
     * @return a String of the answer
     * @throws IOException in case the file is empty or not found
     */
    public static String AnswersReader(int selected) throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream("Answers.dat"), StandardCharsets.UTF_8))) {
            for (int i = 0; i < selected; ++i) {
                // Skip questions until the selected one is reached
                if (reader.readLine() == null) {
                    throw new IOException("The selected question does not exist.");
                }
            }
            // Return the selected answer
            return reader.readLine();
        }
    }
}
