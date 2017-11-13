/**
 * Represents a game of free cell
 * @author Roby Mize
 * @author Taylor Dockery
 *
 */
import java.util.*;

public class FreeCellGame {
	
	private ArrayList<Pile> tableaux = new ArrayList<>();
	private ArrayList<Pile> homeCells = new ArrayList<>();
	private ArrayList<Pile> freeCells = new ArrayList<>();
	private Deck deck;
	
	/**
	 * Constructor.
     * Creates a FreeCell game with 2 players and a shuffled deck
     */
	public FreeCellGame() {
		
		allPiles = new ArrayList<Pile>();
		
		tableaux = new ArrayList<>();
		homeCells = new ArrayList<>();
		freeCells = new ArrayList<>();
		
		//Create the piles and assign them to their respective lists
		for(int i = 0; i < 8; i++) {
			tableaux.add(new Tableau());
		}
		
		for(int i = 0; i < 4; i++) {
			homeCells.add(new HomeCellPile());
			freeCells.add(new FreeCellPile());
		}
		
		deck = new Deck();
		deck.shuffle();
		// Deal out cards to the tableaus
		reset();
	}
	
	
	/**
	 * Returns the homeCell pile at a given index. Starts counting from 1.
	 * @param index
	 * @throws IllegalStateException
	 * @return homeCell pile at position index
	 */
	public Pile getHomePile(int index){
		if (index > 4 || index < 1) throw new IllegalStateException("Index must be between 1 and 4");
		return homeCells.get(index - 1);
	}
	
	public void reset() {
		Deck deck = new Deck();
		deck.shuffle();
		for (Pile p: homeCells) {
			p.clear();
		}
		for (Pile p: freeCells) {
			p.clear();
		}
		for (Pile p: tableaux) {
			p.clear();
		}
		while (!deck.isEmpty())
		{
			for (int i = 1; i < 8 ; i++) {
				for (int j = 1; j <= 4; j++) 
					getTableau(j).add(deck.deal());}
			for (int i = 1; i < 7; i++) {
				for (int j =  5; j <= 8; j++) 
					getTableau(j).add(deck.deal());}
		}
		
	}
	
	
	/**
	 * Returns the freeCell pile at a given index. Starts counting from 1.
	 * @param index
	 * @throws IllegalStateException
	 * @return freeCell pile at position index
	 */
	public Pile getFreePile(int index) {
		if (index > 4 || index < 1) throw new IllegalStateException("Index must be between 1 and 4");
		return freeCells.get(index - 1);
	}
	
	
	/**
	 * Returns the tableau pile at a given index. Starts counting from 1
	 * @param index
	 * @return tableau pile at a given index
	 */
	public Pile getTableau(int index) {
		if (index > 8 || index < 1) throw new IllegalStateException("Index must be between 1 and 8");
		return tableaux.get(index - 1);
	}
	
	
    /**
     * Tests the game for a winner
     * @return true if winner
     */
	public boolean winner() {
		for (Pile homeCell: homeCells) if (homeCell.size() != 13) return false;
		return true;
	}
	
	
	/**
     * Constructs the string representation of a free cell game.
     * @return string representation. 
     */
	public String toString() {
		String result = "FreeCell Game Contents: ";
		for (int i = 1; i < 5; i++) {
			result += String.format("\nHome Cell " + i + ": "  + getHomePile(i));
		}
		for (int i = 1; i < 5; i++) {
			result += String.format("\nFree Cell " + i + ": " + getFreePile(i));
		}
		for (int i = 1; i < 9; i++) {
			result += String.format("\nTableau " + i + ": " + getTableau(i));
		} 
		return result;
	}


	/**
	 * Method used to reset the game.
	 * @return sets to new game. 
	 */
	
		public void dealCards(){
			while (!deck.isEmpty())
			{
				for (int i = 1; i < 8 ; i++) {
					for (int j = 1; j <= 4; j++) 
						getTableau(j).add(deck.deal());}
				for (int i = 1; i < 7; i++) {
					for (int j =  5; j <= 8; j++) 
						getTableau(j).add(deck.deal());}
			}
		}
	
}
