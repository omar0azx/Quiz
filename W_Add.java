import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class W_Add extends JFrame {

    private final JLabel lblQuestion = new JLabel("Enter the question: ");
    private final JTextField txtQuestion = new JTextField(20);
    private final JLabel lblAnswer = new JLabel("Enter the answer: ");
    private final JTextArea txtAnswer = new JTextArea(10,20);
    private final JScrollPane scroll = new JScrollPane(txtAnswer);
    private final JButton btnSave = new JButton("Save");
    private final JButton btnBack = new JButton("Back");
    private final JPanel pnlNorth = new JPanel(new FlowLayout());
    private final JPanel pnlCenter = new JPanel(new FlowLayout());
    private final JPanel pnlSouth = new JPanel(new FlowLayout());

    /**
     * Constructor
     */
    public W_Add() {
        //icon
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("jeddah.jpeg")));
        setIconImage(icon.getImage());
        //resizing the buttons
        btnSave.setPreferredSize(new Dimension(150,20));
        btnBack.setPreferredSize(new Dimension(150,20));


        setTitle("Quizit");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,300);
        setLocationRelativeTo(null);
        buildPanels();
        add(pnlNorth, BorderLayout.NORTH);
        add(pnlCenter, BorderLayout.CENTER);
        add(pnlSouth, BorderLayout.SOUTH);

        //Action Listener
        btnBack.addActionListener(e -> {
            dispose();
            new W_Start();
        });

        btnSave.addActionListener(e -> {
            try {
                FileHandler.FWriter(txtQuestion, txtAnswer);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        setVisible(true);
    }

    /**
     * Builds components into panels
     */
    private void buildPanels(){
        pnlNorth.add(lblQuestion);
        pnlNorth.add(txtQuestion);
        pnlCenter.add(lblAnswer);
        pnlCenter.add(scroll);
        pnlSouth.add(btnBack);
        pnlSouth.add(btnSave);
    }
}
