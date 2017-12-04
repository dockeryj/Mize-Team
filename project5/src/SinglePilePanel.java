import java.awt.*;
import javax.swing.*;

/**
 * Panel that represents any pile that holds only one card.
 * @author Chris_Surran
 *
 */
public class SinglePilePanel extends AbstractPilePanel{
	/**
	 * Constructor for SinglePilePanel
	 * @param p pile the panel represents
	 */
	public SinglePilePanel(Pile p, int R, int G, int B) {
		super(p,R,G,B);
	}
	
	/**
	 * Draws the panel.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Draw the wireframe if there is no card
		
		int y = 5; // We want it to be close to the top
		if (pile.isEmpty() || pile == null){
	    		Icon image = Card.getBack();
	    		g.setColor(Color.yellow);
	    		int x = (getWidth() - image.getIconWidth()) / 2;
	    		g.drawRect(x, y, image.getIconWidth(), image.getIconHeight());
		}
		// Handle Case if there is a card
		else{
	    		Icon image = pile.getTop().getImage();
	    		int x = (getWidth() - image.getIconWidth()) / 2;
	    		image.paintIcon(this, g, x, y);
	    	}
	}
	
	
}