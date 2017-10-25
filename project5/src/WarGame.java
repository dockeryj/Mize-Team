import java.util.List;

/**
 * Represents a game of war
 * @author Roby
 *
 */

public class WarGame {

	private Player player1;
	private Player player2;
	private Deck deck;
	private String gameState = "";
	
	
	/**
     * Creates a war game with 2 players and a shuffled deck
     */
	public WarGame() {
		player1 = new Player();
		player2 = new Player();
		deck = new Deck();
		deck.shuffle();	
		this.deal();
	}
	
	/**
     * Returns string representation of WarGame
     * @return gameState
     */
	public String toString(){
		return gameState;
	    }
	
	/**
     * Deals 26 cards to each player.
     */
    public void deal(){
    		while (! deck.isEmpty()){
    			player1.addToUnplayedPile(deck.deal());
    			player2.addToUnplayedPile(deck.deal());
    		}
    }
	
    /**
     * Makes one move in the game
     * return the two cards played
     */
    public void step(){
    		Card card1 = player1.getCard();
    		Card card2 = player2.getCard();
    		player1.addToWarPile(card1);
		player2.addToWarPile(card2);
    		gameState = "Player 1: " + card1.toString() + "\n" + "Player 2: " + card2.toString();
    		if (card1.getRank() == card2.getRank()) {
    			gameState += "\n Cards added to war pile";
    		}
    		else if (card1.getRank() > card2.getRank()) {
    			gameState += "\n Cards go to Player 1";
    			player1.transferToWinningsPile(player1);
    			player1.transferToWinningsPile(player2);
    		}
    		else{
    			gameState += "\n Cards go to Player 2";
    			player2.transferToWinningsPile(player1);
    			player2.transferToWinningsPile(player2);
    		}
    }
    
    /**
     * Prints a string indicating the player who won with 
     * each player's number of cards, or a tie
     */
    public String winner(){
    		if (player1.isDone() && player2.isDone()) {
    			int count1 = player1.winningsCount();
    			int count2 = player2.winningsCount();
    			if (count1 > count2) {
    				return("Player 1 wins," + Integer.toString(count1) + "to" + Integer.toString(count2));
    			}
    			else if (count1 < count2) {
    				return("Player 2 wins, " + Integer.toString(count2) + " to " + Integer.toString(count1));
    			}
    			else return("The game ends in a tie");
    		}
    		else return(null);
    }
	
}
