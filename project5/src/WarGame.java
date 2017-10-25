import java.util.ArrayList;
import java.util.List;

/**
 * Represents a game of war
 * @author Roby
 *
 */

public class WarGame {

	public  Player player1;
	public  Player player2;
	private Deck deck;
	private String gameState = "";
	private List<Card> warPile;
	private int moveCount = 0;
	private String statistics1 = "";
	private String lineSpaces = String.format("%n%n");
	private String statistics2 = "";
	private Card card1;
	private Card card2;
	
	/**
     * Creates a war game with 2 players and a shuffled deck
     */
	public WarGame() {
		player1 = new Player();
		player2 = new Player();
		warPile = new ArrayList<Card>();
		deck = new Deck();
		deck.shuffle();	
		while (! deck.isEmpty()){
			player1.addToUnplayedPile(deck.deal());
			player2.addToUnplayedPile(deck.deal());
		}
		
	}
	
	/**
     * Returns string representation of WarGame
     * @return gameState
     */
	public String toString(){
		statistics1 = String.format("Player 1:%nCurrent Card:%nUnplayed pile:%nWar pile:%nWinnings pile:"); 
		statistics2 = String.format("Player 2:%nCurrent Card:%nUnplayed pile:%nWar pile:%nWinnings pile:");
		gameState = statistics1 + lineSpaces + statistics2 + lineSpaces + this.moveCount;
		return gameState;
	}
	
	
    /**
     * Makes one move in the game
     */
    public void step(){ 
    		moveCount += 1;
    		card1 = player1.getCard();
    		card2 = player2.getCard();
    		warPile.add(card1);
		warPile.add(card2);
    		if (card1.getRank() > card2.getRank()) {
    			while (! warPile.isEmpty()) {
    				player1.addToWinningsPile(warPile.remove(0));
    			}
    		}
    		else{
    			while (! warPile.isEmpty()) {
    				player2.addToWinningsPile(warPile.remove(0));
    			}
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
