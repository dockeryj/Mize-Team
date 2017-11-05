/**
 * Represents a FreeCellPile
 * @author Chris_Surran
 *
 */
import java.util.ArrayList;
public class Tableau extends AbstractPile{
	/**
     * Constructor.
     */
	public Tableau() { 
		super(52); // 52 because we do not care if to many cards end up in one pile after start
	}
	
	
	public boolean canTransfer(Pile sourcePile, int low, int high) {
		if (! super.canTransfer(sourcePile)) return false;
		if (! sourcePile.inOrder(low, high)) return false;
		return true;
	}
	
	public boolean transfer(Pile sourcePile, int low, int high) {
		if (low < 0 || high > sourcePile.size() - 1) throw new IllegalStateException("Illegal!!!! index");
		if(! canTransfer(sourcePile, low, high)) return false;
		//ArrayList<Card> cardsToAdd = new ArrayList<>();
		for (int i = low; i <= high; i++) this.add(sourcePile.remove(0));
		//for (Card c: cardsToAdd) this.add(c);
		return true; // Check to make sure cards are added in order
	}
	
}