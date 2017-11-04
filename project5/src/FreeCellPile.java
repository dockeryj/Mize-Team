import java.util.*;

/**
 * Represents a FreeCellPile
 * @author Roby Mize
 *
 */

public class FreeCellPile extends AbstractPile{
	
	private List<Card> freecellpile;
	
	/**
     * Constructor.
     */
	public FreeCellPile() {
		super(1);
	}
	
	public void add(Card cardToBeAdded) {
		if (! freecellpile.isEmpty()) {
			throw new RuntimeException("Illegal Move!");
		}
		else {
			freecellpile.add(cardToBeAdded);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}