import java.util.ArrayList;
import java.util.List;

/**
 * Represents a player in a game of war
 * @author Roby
 *
 */


public class Player {
	
	private List<Card> unplayedPile;
	private List<Card> winningsPile;
	
    /**
     * Creates a player with empty unplayed pile and winnings pile
     */
    public Player(){
    	unplayedPile = new ArrayList<Card>();
	winningsPile = new ArrayList<Card>();
    }
	
	
	/**
     * Adds card to the players unplayed pile.
     */
    public void addToUnplayedPile(Card card){
    		unplayedPile.add(card);
    }
    
    /**
     * Adds card to the players winnings pile.
     */
    public void addToWinningsPile(Card card){
    		winningsPile.add(card);
    }
    
    /**
     * Removes and returns a card from the player's unplayed pile
     * @return the card from player's unplayed pile
     */
    public Card getCard(){
    		return unplayedPile.remove(0);
    		//this needs to be fixed. Index out of bounds exception when there is nothing left in the unplayed pile
    }
    
    /**
     * Returns True if the player's unplayed pile is empty,
     * or False otherwise
     * @return True if unplayed pile is empty, or false otherwise
     */
    public boolean isDone(){
    		if (unplayedPile.size() == 0) return true;
    		else return false;
    }
    
    
    /**
     * Returns the number of cards in the player's winnings pile.
     * @return the number of cards in player's winnings pile
     */
    public int winningsCount(){
    		return winningsPile.size();
    }	
    
    /**
     * Returns the number of cards in the player's winnings pile.
     * @return the number of cards in player's winnings pile
     */
    public int unplayedCount(){
    		return unplayedPile.size();
    }	
}
