/**
 * Represents a FreeCellPile
 * @author Chris_Surran
 * @author Cooper_Breithaupt
 *
 */

public class HomeCellPile extends AbstractPile{
	
	/**
     * Constructor for HomeCellPile
     */
	public HomeCellPile(){
		super(13);
	}
	
	/**
     * Determines if a pile can be transferred from a source pile.
     * @param sourcePile the sourcePile
     * @return true if pile can be transferred
     */
	public boolean canTransfer(Pile sourcePile){
		if (! super.canTransfer(sourcePile)) return false;
		Card sourceCard = sourcePile.getTop();
		if (sourcePile instanceof HomeCellPile) return false;
		else if (isEmpty()) {
			if (sourceCard.getRank() == 1) return true;
			else return false;}
		else {
			Card homeCard = getTop();
			Suit targetSuit = homeCard.getSuit();
			int targetRank = homeCard.getRank() + 1;
			Card targetCard = new Card(targetSuit, targetRank);
			//System.out.println(targetCard);
			//System.out.println(sourceCard);
			//System.out.println((sourceCard.compareTo(targetCard) == 0));
			if (sourceCard.getRank() == targetCard.getRank() && sourceCard.getSuit() == targetCard.getSuit()) return true;
			else return false;}	
	}
}