import java.awt.*;
import javax.swing.*;


public class SinglePilePanel extends AbstractPilePanel{
	
	public SinglePilePanel(Pile p) {
		super(p);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Draw the wireframe if their is no card
		
		int y = 5; // We want it to be close to the top
		if (pile.isEmpty() || pile == null){
	    		Icon image = Card.getBack();
	    		g.setColor(Color.yellow);
	    		int x = (getWidth() - image.getIconWidth()) / 2;
	    		g.drawRect(x, y, image.getIconWidth(), image.getIconHeight());
		}
		// Handle Case if their is a card
		else{
	    		Icon image = pile.getTop().getImage();
	    		int x = (getWidth() - image.getIconWidth()) / 2;
	    		image.paintIcon(this, g, x, y);
	    	}
	}
	
	
}