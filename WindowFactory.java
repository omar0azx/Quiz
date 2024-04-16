import javax.swing.JFrame;

public class WindowFactory {

    public enum WindowType {
        START, ADD, QUIZ, SELECTED_QUIZ
    }

    public static JFrame createWindow(WindowType type, Object... params) {
        switch (type) {
            case START:
                return new W_Start();
            case ADD:
                return new W_Add();
            case QUIZ:
                return new W_Quiz();
            case SELECTED_QUIZ:
                if (params.length >= 2 && params[0] instanceof String && params[1] instanceof Integer) {
                    return new W_SelectedQuiz((String) params[0], (Integer) params[1]);
                } else {
                    throw new IllegalArgumentException("Invalid parameters for SELECTED_QUIZ window");
                }
            default:
                throw new IllegalArgumentException("Unknown window type: " + type);
        }
    }
}
