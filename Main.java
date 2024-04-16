// public class Main {
//     public static void main(String[] args) {
//         new W_Start();
//     }
// }

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame startWindow = WindowFactory.createWindow(WindowFactory.WindowType.START);
        startWindow.setVisible(true);
    }
}
