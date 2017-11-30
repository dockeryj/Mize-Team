import javax.swing.JPanel;
import java.awt.*;

/**
 * Forms the basis of all card panels
 * @author Chris_Surran
 */
public class AbstractPilePanel extends JPanel{
	protected Pile pile; 
	public Object viewController;
	
	/**
	 * Constructor for AbstractPilePanel
	 * @param p pile the panel represents
	 */
	public AbstractPilePanel(Pile p, Object i) {
		pile = p;
		setBackground(new Color(51, 102, 0));
		viewController = i;
	}
	/**
	 * Draws the panel.
	 */
	public void PaintCompoenent(Graphics g) {
		super.paintComponent(g);	
	}

	public Pile getCell() {
		return pile;
	}

	
}