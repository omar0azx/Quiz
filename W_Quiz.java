import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

public class W_Quiz extends JFrame implements ActionListener {
    private final JButton btnSelect;
    private final JButton btnBack;
    private JList<String> lst;
    JMenuBar menuBar;
    JMenu file,help,info,contact;
    JMenuItem close,phone,email,creators;

    {
        try {
            lst = new JList<>(FileHandler.QuestionsReader());
        } catch (IOException ignored) {}
    }

    private final JScrollPane scroll = new JScrollPane(lst);


    /**
     * Constructor
     */
    W_Quiz(){
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("jeddah.jpeg")));
        setIconImage(icon.getImage());


        //create menu bar
        menuBar = new JMenuBar();
        //create the menu
        file = new JMenu("File");
        help = new JMenu("Help");
        info = new JMenu("Info");
        contact = new JMenu("Contact");

        //create menu items
        close = new JMenuItem("Close");
        phone = new JMenuItem("Phone");
        email = new JMenuItem("Email");
        creators = new JMenuItem("Creators");


        //add action listeners
        close.addActionListener(this);
        phone.addActionListener(this);
        email.addActionListener(this);
        creators.addActionListener(this);

        //add menu items to menu
        file.add(close);
        contact.add(email);
        contact.add(phone);
        info.add(creators);
        help.add(contact);

        //adding to menu bar
        menuBar.add(file);
        menuBar.add(info);
        menuBar.add(help);

        //adding the menu bar to the screen
        this.setJMenuBar(menuBar);


        //Label
        JLabel lblChoice = new JLabel("Select a question");

        try {
            //list
            lst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            lst.setSelectedIndex(0);
        }catch (NullPointerException ignored){}

        //buttons
        btnSelect = new JButton();
        btnSelect.setText("Select");
        btnSelect.setPreferredSize(new Dimension(150,20));
        btnSelect.addActionListener(e -> {
            new W_SelectedQuiz(lst.getSelectedValue(), lst.getSelectedIndex());
            dispose();
        });

        btnBack = new JButton();
        btnBack.setText("Back");
        btnBack.setPreferredSize(new Dimension(150,20));
        btnBack.addActionListener(this);


        //panel
        JPanel panel = new JPanel();
        panel.add(btnBack);
        panel.add(btnSelect);


        this.setTitle("Quiz Window");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420,420);
        this.setLocationRelativeTo(null);
        this.add(lblChoice, BorderLayout.NORTH);
        this.add(scroll, BorderLayout.CENTER);
        this.add(panel, BorderLayout.SOUTH);
        this.setVisible(true);
    }


    /**
     * When Button pressed or user chose from the menu
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== btnBack){
            this.dispose();
            new W_Start();
        }
        if(e.getSource()==close){
            System.exit(0);
        }
        if(e.getSource()==email){
            JOptionPane.showMessageDialog(null,"Help@email.com");
        }
        if(e.getSource()==phone){
            JOptionPane.showMessageDialog(null,"0555555555");
        }
        if(e.getSource()==creators){
            JOptionPane.showMessageDialog(null,"Amin and Sameer");
        }
    }
}
