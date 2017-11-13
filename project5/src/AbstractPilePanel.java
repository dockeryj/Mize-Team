import javax.swing.JPanel;
import java.awt.*;

public class AbstractPilePanel extends JPanel{
	protected Pile pile; 
	
	public AbstractPilePanel(Pile p) {
		pile = p;
		setBackground(new Color(51, 102, 0));
	}
	public void PaintCompoenent(Graphics g) {
		super.paintComponent(g);	
	}
	
	// This Class will most likely be where we add our methods to respond to mouse
	// presses
}