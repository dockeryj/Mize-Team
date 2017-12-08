/**
 * Represents a FreeCellPile
 * @author Chris_Surran
 *
 */
public class Tableau extends AbstractPile{
	/**
     * Constructor.
     */
	public Tableau() { 
		super(52); // 52 because we do not care if too many cards end up in one pile after start
	}
	
	/**
     * Checks to see if the pile can be transferred to the pile from a source pile
     * @param low integer. 
     * @param high integer.
     * @throws IllegalStateException if index is out of bounds. 
     * @return true if the pile can be transferred.
     */
	public boolean canTransfer(Pile sourcePile) {
//		if (low < 0 || high > sourcePile.size() - 1) throw new IllegalStateException("Illegal index");
//		if (! super.canTransfer(sourcePile)) return false;
//		if (! sourcePile.inOrder(low, high)) return false;
		if(size() == 0) return true;
		Card bottomSourceCard = sourcePile.getTop();
		System.out.println(sourcePile.getTop());
		Card topCard = this.getTop();
		System.out.println(topCard);
		if (!getNextSuit(topCard).contains(bottomSourceCard.getSuit()) || !(bottomSourceCard.getRank() == topCard.getRank() - 1)) return false;
		return true;
	}
	
	/**
     * Checks to see if the cards in a subsection of a pile are in order
     * @param low integer. 
     * @param high integer.
     * @throws IllegalStateException if index is out of bounds. 
     * @return true if they are in order
     */
	public boolean transfer(Pile sourcePile) {
//		if (low < 0 || high > sourcePile.size() - 1) throw new IllegalStateException("Illegal index");
		if(! canTransfer(sourcePile)) return false;
		this.add(sourcePile.remove(sourcePile.size() - 1));
		return true; 
	}
	

}