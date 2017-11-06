import java.util.ArrayList;
import java.util.Iterator;
public interface Pile {
	
	/**
     * Returns a string representation of the pile.
     * @return String representation. 
     */
	public abstract String toString();
	/**
     * Returns the size of the pile.
     * @return The size of the pile.
     */
	public abstract int size(); 
	
	/**
     * Returns the max size of the pile.
     * @return The max size of the pile.
     */
	public abstract int maxSize(); 
	
	/**
     * Returns the card at the top of the pile.
     * @throws IllegalStateException if cell is empty.
     * @return Top card.
     */
	public abstract Card getTop(); 
	
	/**
     * Clears the pile.
     */
	public abstract void clear(); 
	
	/**
     * Adds a card to the pile.
     * @param cardToBeAdded The card to be added.
     */
	public abstract void add(Card cardToBeAdded); 
	
	/**
     * Removes the card at the top of the pile.
     * @throws IllegalStateException if cell is empty.
     * @return Removed card.
     */
	public abstract Card remove(); 
	
	/**
     * Removes the card at a given index.
     * @param i Index of card.
     * @throws IllegalStateException if index is out of bounds.
     * @return Removed card.
     */
	public abstract Card remove(int i);
	
	/**
     * Transfers a card to a source pile
     * @param sourcePile the source pile. 
     * @return True if card is transferred.
     */
	public abstract boolean transfer(Pile sourcePile); 
	
	/**
     * Determines if a card can be transferred to a source pile
     * @param sourcePile the source pile. 
     * @return True if card can be transferred.
     */
	public abstract boolean canTransfer(Pile sourcePile); 
	
	/**
     * Determines if a pile is empty.
     * @return True if pile is empty.
     */
	public abstract boolean isEmpty(); 
	
	/**
     * Creates a card type iterator for the pile.
     * @return Iterator for the pile. 
     */
	public abstract Iterator<Card> iterator(); 
	
	/**
     * Checks to see if the cards in a subsection of a pile are in order
     * @param low integer. 
     * @param high integer.
     * @throws IllegalStateException if index is out of bounds. 
     * @return true if they are in order
     */
	public abstract boolean inOrder(int low, int high);
	
	/**
     * Retrieves a card at a given index. 
     * @param i integer. 
     * @throws IllegalStateException if index is out of bounds. 
     * @return Card at given index. 
     */
	public abstract Card get(int i);
	
	/**
     * Returns an array list of acceptable suits for the next card
     * @param c Card
     * @return ArrayList<Suit> containing next acceptable suits
     */
	public abstract ArrayList<Suit> getNextSuit(Card c);
}
