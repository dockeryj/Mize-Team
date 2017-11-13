/**
 * Forms the basis of all piles in the freecell game
 * @author Chris Surran
 *
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public abstract class AbstractPile implements Pile, Iterable<Card>
{
	private List<Card> abstractPile;
	private int maxSize; 
	
	 /**
     * Constructor.
     * @param size size of the pile
     */
	public AbstractPile(int size)
	{
		abstractPile = new ArrayList<Card>();
		this.maxSize = size;
	}
	
	
	public int size(){ 
		return abstractPile.size();}
	
	
	public int maxSize(){ 
		return maxSize;}
	
	
	public void clear(){
		abstractPile.clear();}
	
	
	
	public void add(Card cardToBeAdded){
		abstractPile.add(cardToBeAdded);}
	
	
	public Card getTop(){
		if (isEmpty()) throw new IllegalStateException("Cell is Empty");
		return (Card)abstractPile.get(abstractPile.size() - 1);
	}
	
	
	public Card remove() {
		if (isEmpty()) throw new IllegalStateException("Cannot remove from an empty stack.");
		return (Card)abstractPile.remove(abstractPile.size() - 1);}
	
	
	public Card remove(int i) {
		if (i < 0 || i > size() - 1) throw new IllegalStateException("Invalid index.");
		return (Card)abstractPile.remove(i);
	}
	
	
	public boolean canTransfer(Pile sourcePile) {
		return((size() < maxSize()) && (!sourcePile.isEmpty()) && (!(sourcePile instanceof HomeCellPile)));}
	
	
	public boolean transfer(Pile sourcePile) {
		if (! canTransfer(sourcePile)) return false;
		abstractPile.add(sourcePile.remove());
		return true;
	}
	
	
	public boolean isEmpty() {
		return abstractPile.isEmpty();}
	
	
	public Iterator<Card> iterator(){
		return abstractPile.iterator();}
	
	
	public String toString(){
		String s = "";
		if (isEmpty()) return s;
		for (Card c: abstractPile)
		{
			s+= (c.toString() + ", ");
		}
		return s.substring(0, s.length() - 2); 
	}
	
	
	public Card get(int i) {
		if(i < 0 || (i > maxSize() - 1)) throw new IllegalStateException("Must enter valid index.");
		return (Card) abstractPile.get(i);
	}
	
	
	public boolean inOrder(int low, int high) { 
		int nextRank = -1;
		if (low < 0 || high > size() - 1) throw new IllegalStateException("Illegal index");
		ArrayList<Suit> possibleSuits = new ArrayList<>();
		for(int i = low; i <= high; i++) {
			Card c = get(i);
			if (nextRank == -1) { // this will only trigger for first card
				possibleSuits = getNextSuit(c);
				nextRank = c.getRank() - 1;}
			else { 
				if (!(c.getRank() == nextRank) || (!possibleSuits.contains(c.getSuit()))) {
				//System.out.println("Card: " + c +"; PossibleSuits: " + possibleSuits + "; Next Rank: " + nextRank); used for testing
				return false;
				}
				possibleSuits = getNextSuit(c);
				nextRank = c.getRank() - 1;
			
			}
		}
		return true; 
	}
	
	
	public ArrayList<Suit> getNextSuit(Card c){
		ArrayList<Suit> possibleSuits = new ArrayList<>();
		if ((c.getSuit().equals(Suit.club)) || (c.getSuit().equals(Suit.spade))){ 
			possibleSuits.add(Suit.diamond);
			possibleSuits.add(Suit.heart);}
		else {
			possibleSuits.add(Suit.club);
			possibleSuits.add(Suit.spade);}
		return possibleSuits;}
}
