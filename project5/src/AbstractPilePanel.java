import javax.swing.JPanel;
import java.awt.*;

/**
 * Forms the basis of all card panels
 * @author Chris_Surran
 */
public class AbstractPilePanel extends JPanel{
	protected Pile pile; 
	/**
	 * Constructor for AbstractPilePanel
	 * @param p pile the panel represents
	 */
	public AbstractPilePanel(Pile p) {
		pile = p;
		setBackground(new Color(51, 102, 0));
	}
	/**
	 * Draws the panel.
	 */
	public void PaintCompoenent(Graphics g) {
		super.paintComponent(g);	
	}
	
	// This Class will most likely be where we add our methods to respond to mouse
	// clicks
}