import javax.swing.JFrame;

//just includes a main method to run the application
public class FreeCellApp {

    public static void main(String[] args){
    		final FreeCellGame model = new FreeCellGame();
	    final JFrame view = new AppView(model);
	    view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    view.setSize(800, 500);
	    view.setVisible(true);
	    }
}

