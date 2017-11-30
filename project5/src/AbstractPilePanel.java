import javax.swing.JPanel;
import java.awt.*;

/**
 * Forms the basis of all card panels
 * @author Chris_Surran
 */
public class AbstractPilePanel extends JPanel{
	protected Pile pile; 
	public Panel panelPressed;
	
	/**
	 * Constructor for AbstractPilePanel
	 * @param p pile the panel represents
	 */
	public AbstractPilePanel(Pile p, Panel i) {
		pile = p;
		setBackground(new Color(51, 102, 0));
		panelPressed = i;
	}
	/**
	 * Draws the panel.
	 */
	public void PaintCompoenent(Graphics g) {
		super.paintComponent(g);	
	}
	
	// This Class will most likely be where we add our methods to respond to mouse
	// clicks
	
	public Card getCell() {
		return pile.getTop();
	}
	
	public void transfer() {
		
	}
	
}