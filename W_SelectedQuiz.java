import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.io.IOException;

public class W_SelectedQuiz extends JFrame{
    private final JLabel lblQuestion = new JLabel();
    private final JTextArea txtRealAnswer = new JTextArea(5,5);
    private final JTextArea txtAnswer = new JTextArea(5,5);
    private final JButton btnShow = new JButton("Show answer");
    private final JButton btnBack = new JButton("Back");
    private final JPanel pnlShow = new JPanel();
    private final JPanel pnlBack = new JPanel();


    /**
     * @param question Question picked used to set text for lblQuestion
     * @param questionIndex Question index is used to find the index of the answer
     */
    public W_SelectedQuiz(String question, int questionIndex){
        setTitle("Quizit");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5,1));

        //JText
        lblQuestion.setText(question);

        //JTextArea
        txtRealAnswer.setEditable(false);
        txtRealAnswer.setBackground(Color.LIGHT_GRAY);
        txtRealAnswer.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
        txtAnswer.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
        txtAnswer.setToolTipText("Enter your text here");

        //Buttons
        btnBack.addActionListener(e -> {
            new W_Quiz();
            dispose();
        });

        btnShow.addActionListener(e -> {
            if(btnShow.getText().equals("Hide")) {
                txtRealAnswer.setText("");
                btnShow.setText("Show");
            }else{
                try {
                    txtRealAnswer.setText(FileHandler.AnswersReader(questionIndex));
                    btnShow.setText("Hide");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,"File not found"); // In case Answers.dat got deleted
                }
            }
        });


        //Adding components
        add(lblQuestion);
        add(txtRealAnswer);
        pnlShow.add(btnShow);
        add(pnlShow);
        add(txtAnswer);
        pnlBack.add(btnBack);
        add(pnlBack);

        setVisible(true);
    }
}
