import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    /**
     * Method will be called by W_Add
     * @param txtQuestion takes the question from W_Add
     * @param txtAnswers takes the answer from W_Add
     */
    public static void FWriter(JTextField txtQuestion, JTextArea txtAnswers) throws IOException {
        DataOutputStream Questionwriter = new DataOutputStream(new FileOutputStream("Questions.dat", true));
        DataOutputStream Answerswriter = new DataOutputStream(new FileOutputStream("Answers.dat", true));
        //In case input was blank
        if(txtQuestion.getText().isBlank() | txtAnswers.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Wrong input");
        }else {
            //Writes in the Questions.dat
            Questionwriter.writeUTF(txtQuestion.getText());
            Questionwriter.close();

            //Write in Answers.dat
            Answerswriter.writeUTF(txtAnswers.getText());
            Answerswriter.close();

            JOptionPane.showMessageDialog(null, "Save successful");
        }
    }

    /**
     * This method gets called by W_Quiz
     * @return An array of string of Questions.dat
     * @throws IOException in case the file is empty
     */
    public static String[] QuestionsReader() throws IOException {
        ArrayList<String> arrayQuestions = new ArrayList<>();
        RandomAccessFile raf = new RandomAccessFile("Questions.dat", "r");
        //loop to read the whole Questions.dat
        for (;;) {
            try {
                arrayQuestions.add(raf.readUTF());
            }catch (EOFException e){
                raf.close();
                return arrayQuestions.toArray(new String[0]); // Converting ArrayList to Array of strings
            }
        }
    }

    /**
     * This method gets called by W_SelectedQuiz
     * @return a String
     * @throws IOException in case the file is empty
     */
    public static String AnswersReader(int selected) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("Answers.dat", "r");
        //loop to read the whole Questions.dat
        for (int i = 0;; ++i) {
            try {
                if(i == selected) {
                    return raf.readUTF();
                }
                raf.readUTF();
            }catch (EOFException e){
                raf.close();
            }
        }
    }
}
