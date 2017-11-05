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
	
	public boolean inOrder(int low, int high) { // remember that size -1 is the top.
		int nextRank;
		if (low < 0 || high > size() - 1) throw new IllegalStateException("Illegal index");
		ArrayList<Suit> possibleSuits = new ArrayList<>();
		for(int i = low; i <= high; i++) {
			Card c = get(i);
			possibleSuits = getNextSuit(c);
			nextRank = c.getRank() - 1;
			if (!(c.getRank() == nextRank) || (!possibleSuits.contains(c.getSuit()))) {
				System.out.println("Card: " + c +"; PossibleSuits: " + possibleSuits + "; Next Rank: " + nextRank);
				return false;
				}
			}
		return true; // return true if you make it all the way through the pile 
	}

	public ArrayList<Suit> getNextSuit(Card c){
		ArrayList<Suit> possibleSuits = new ArrayList<>();
		if ((c.getSuit().equals(Suit.club)) || (c.getSuit().equals(Suit.spade))){ // next card must be red
			possibleSuits.add(Suit.diamond);
			possibleSuits.add(Suit.heart);}
		else {
			possibleSuits.add(Suit.club);
			possibleSuits.add(Suit.spade);}
		return possibleSuits;
	}
	
	
	public boolean canTransfer(Pile sourcePile, int low, int high) {
		if (low < 0 || high > size() - 1) throw new IllegalStateException("Illegal index");
		if (! super.canTransfer(sourcePile)) return false;
		if (! inOrder(low, high)) return false;
		return true;
	}
	
	public boolean transfer(Pile sourcePile, int low, int high) {
		if(! canTransfer(sourcePile, low, high)) return false;
		//ArrayList<Card> cardsToAdd = new ArrayList<>();
		for (int i = low; i <= high; i++) this.add(sourcePile.remove(i));
		//for (Card c: cardsToAdd) this.add(c);
		return true; // Check to make sure cards are added in order
	}
	
}