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
	
	/**
     * Returns the size of the pile.
     * @return The size of the pile.
     */
	public int size(){ 
		return abstractPile.size();}
	
	/**
     * Returns the max size of the pile.
     * @return The max size of the pile.
     */
	public int maxSize(){ 
		return maxSize;}
	
	/**
     * Clears the pile.
     * 
     */
	public void clear(){
		abstractPile = new ArrayList<Card>();}
	
	
	/**
     * Adds a card to the pile.
     * @param cardToBeAdded The card to be added.
     */
	public void add(Card cardToBeAdded){
		abstractPile.add(cardToBeAdded);}
	
	/**
     * Returns the card at the top of the pile.
     * @throws IllegalStateException if cell is empty.
     * @return Top card.
     */
	public Card getTop(){
		if (isEmpty()) throw new IllegalStateException("Cell is Empty");
		return (Card)abstractPile.get(abstractPile.size() - 1);
	}
	
	/**
     * Removes the card at the top of the pile.
     * @throws IllegalStateException if cell is empty.
     * @return Removed card.
     */
	public Card remove() {
		if (isEmpty()) throw new IllegalStateException("Cannot remove from an empty stack.");
		return (Card)abstractPile.remove(abstractPile.size() - 1);}
	
	/**
     * Removes the card at a given index.
     * @param i Index of card.
     * @throws IllegalStateException if index is out of bounds.
     * @return Removed card.
     */
	public Card remove(int i) {
		if (i < 0 || i > size() - 1) throw new IllegalStateException("Invalid index.");
		return (Card)abstractPile.remove(i);
	}
	
	/**
     * Determines if a card can be transferred to a source pile
     * @param sourcePile the source pile. 
     * @return True if card can be transferred.
     */
	public boolean canTransfer(Pile sourcePile) {
		return((size() < maxSize()) && (!sourcePile.isEmpty()) && (!(sourcePile instanceof HomeCellPile)));}
	
	/**
     * Transfers a card to a source pile
     * @param sourcePile the source pile. 
     * @return True if card is transferred.
     */
	public boolean transfer(Pile sourcePile) {
		if (! canTransfer(sourcePile)) return false;
		abstractPile.add(sourcePile.remove());
		return true;
	}
	
	/**
     * Determines if a pile is empty.
     * @return True if pile is empty.
     */
	public boolean isEmpty() {
		return abstractPile.isEmpty();}
	
	/**
     * Creates a card type iterator for the pile.
     * @return Iterator for the pile. 
     */
	public Iterator<Card> iterator(){
		return abstractPile.iterator();}
	
	/**
     * Returns a string representation of the pile.
     * @return String representation. 
     */
	public String toString(){
		String s = "";
		for (Card c: abstractPile)
		{
			s+= (c.toString() + "\n");
		}
		return s; 
	}
	
	/**
     * Retrieves a card at a given index. 
     * @param i integer. 
     * @throws IllegalStateException if index is out of bounds. 
     * @return Card at given index. 
     */
	public Card get(int i) {
		if(i < 0 || (i > maxSize() - 1)) throw new IllegalStateException("Must enter valid index.");
		return (Card) abstractPile.get(i);
	}
	
	/**
     * ?
     * @param low integer. 
     * @param high integer.
     * @throws IllegalStateException if index is out of bounds. 
     * @return ?
     */
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
	
	/**
     * ?
     * @param c Card
     * @return ?
     */
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
