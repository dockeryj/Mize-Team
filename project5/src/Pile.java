import java.util.ArrayList;
import java.util.Iterator;
/**
 * Represents a FreeCellPile
 * @author Chris_Surran
 *
 */

public interface Pile {
	
	/**
     * Returns a string representation of the pile.
     * @return String representation. 
     */
	public String toString();
	
	/**
     * Returns the size of the pile.
     * @return The size of the pile.
     */
	public int size(); 
	
	/**
     * Returns the max size of the pile.
     * @return The max size of the pile.
     */
	public int maxSize(); 
	
	/**
     * Returns the card at the top of the pile.
     * @throws IllegalStateException if cell is empty.
     * @return Top card.
     */
	public Card getTop(); 
	
	/**
     * Clears the pile.
     */
	public void clear(); 
	
	/**
     * Adds a card to the pile.
     * @param cardToBeAdded The card to be added.
     */
	public void add(Card cardToBeAdded); 
	
	/**
     * Removes the card at the top of the pile.
     * @throws IllegalStateException if cell is empty.
     * @return Removed card.
     */
	public Card remove(); 
	
	/**
     * Removes the card at a given index.
     * @param i Index of card.
     * @throws IllegalStateException if index is out of bounds.
     * @return Removed card.
     */
	public Card remove(int i);
	
	/**
     * Transfers a card to a source pile
     * @param sourcePile the source pile. 
     * @return True if card is transferred.
     */
	public boolean transfer(Pile sourcePile); 
	
	/**
     * Determines if a card can be transferred to a source pile
     * @param sourcePile the source pile. 
     * @return True if card can be transferred.
     */
	public boolean canTransfer(Pile sourcePile); 
	
	/**
     * Determines if a pile is empty.
     * @return True if pile is empty.
     */
	public boolean isEmpty(); 
	
	/**
     * Creates a card type iterator for the pile.
     * @return Iterator for the pile. 
     */
	public Iterator<Card> iterator(); 
	
	/**
     * Checks to see if the cards in a subsection of a pile are in order
     * @param low integer. 
     * @param high integer.
     * @throws IllegalStateException if index is out of bounds. 
     * @return true if they are in order
     */
	public boolean inOrder(int low, int high);
	
	/**
     * Retrieves a card at a given index. 
     * @param i integer. 
     * @throws IllegalStateException if index is out of bounds. 
     * @return Card at given index. 
     */
	public Card get(int i);
	
	/**
     * Returns an array list of acceptable suits for the next card
     * @param c Card
     * @return ArrayList<Suit> containing next acceptable suits
     */
	public ArrayList<Suit> getNextSuit(Card c);
}
