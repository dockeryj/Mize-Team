import javax.swing.JFrame;

/**
 * Generic main method template for any GUI-based application.
 * Instantiates a model and passes it to a new view.
 * @author lambertk
 *
 */
public class GUIApp{

    public static void main(String[] args){
        final WarGame model = new WarGame();
        final JFrame view = new MainView(model);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setSize(600, 400);
        view.setVisible(true);
    }
}