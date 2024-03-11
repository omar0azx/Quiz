import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class W_Start extends JFrame implements ActionListener {
    JButton btnAddWindow = new JButton();
    JButton btnQuizWindow = new JButton();
    JMenuBar menuBar;
    JMenu file,help,info,contact;
    JMenuItem close,phone,email,creators;


    /**
     * Constructor
     */
    W_Start(){
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


        //define the Two buttons
            btnAddWindow.setText("Add a new sentence");
            btnQuizWindow.setText("Quiz!");

            btnAddWindow.setPreferredSize(new Dimension(150,20));
            btnQuizWindow.setPreferredSize(new Dimension(150,20));

            btnAddWindow.addActionListener(this);
            btnQuizWindow.addActionListener(this);


            // setting the Image
            ImageIcon image = new ImageIcon(Objects.requireNonNull(getClass().getResource("jeddah.jpeg")));


            // the label Obviously
            JLabel label;
            label = new JLabel(image);


            //Panel and Adding Components to it "in order"
            JPanel panel = new JPanel(new FlowLayout());
            panel.add(btnAddWindow);
            panel.add(label);
            panel.add(btnQuizWindow);


            //this for the JFrame, I know you know
            this.setTitle("Main Window");

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(600,270);
            this.setLocationRelativeTo(null);
            this.add(panel);
            this.setVisible(true);
     }

    /**
     * When Button pressed
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== btnAddWindow){
            //this will only go to the "Add" Screen
            this.dispose();
            new W_Add();
        }
        if (e.getSource()==btnQuizWindow) {
            // this will only go to "Quiz" Screen
            this.dispose();
            new W_Quiz();
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
