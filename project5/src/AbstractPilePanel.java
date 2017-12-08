import javax.swing.JPanel;
import java.awt.*;
import java.util.Random;

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
	public AbstractPilePanel(Pile p, int R, int G, int B) {
		int nR = R;
		int nG = G;
		int nB = B;
		pile = p;
		setBackground(new Color(nR, nG, nB));
		
	}
	
	/**
	 * Draws the panel.
	 */
	public void PaintCompoenent(Graphics g) {
		super.paintComponent(g);	
	}

	/**
	 * Gets the cell
	 */
	public Pile getCell() {
		return pile;
	}

	
}