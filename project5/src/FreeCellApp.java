import javax.swing.JFrame;

/**
 * Contains a GUI based Free Cell Game. 
 * @author Chris_Surran, Taylor_Dockery, Roby_Mize, Cooper_Breithaupt
 */
public class FreeCellApp {

    public static void main(String[] args){
    		final FreeCellGame model = new FreeCellGame();
	    final JFrame view = new AppView(model);
	    view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    view.setSize(800, 800);
	    view.setVisible(true);
	    view.setResizable(false);
	    }
}

