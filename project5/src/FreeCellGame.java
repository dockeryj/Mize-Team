import java.util.*;

/**
 * Represents a game of free cell
 * @author Roby Mize
 * @author Taylor Dockery
 *
 */


public class FreeCellGame {
	
	private FreeCellPile FC1, FC2, FC3, FC4;
	private HomeCellPile HC1, HC2, HC3, HC4;
	private Tableau T1, T2, T3, T4, T5, T6, T7, T8;
	private Deck deck;
	//private List<Tableau> tableauArray = new ArrayList<Tableau>(T1,T2,T3,T4,T5,T6,T7,T8);
	
	//Constructor
	/**
     * Creates a FreeCell game with 2 players and a shuffled deck
     */
	
	public FreeCellGame() {
		FC1 = FC2 = FC3 = FC4 = new FreeCellPile();
		HC1 = HC2 = HC3 = HC4 = new HomeCellPile();
		T1 = T2 = T3 = T4 = T5 = T6 = T7 = T8 = new Tableau();
		deck = new Deck();
		deck.shuffle();
		while (!deck.isEmpty()) {
			for (int i = 1; i <= 7; i++) {
				T1.add(deck.deal());
				T2.add(deck.deal());
				T3.add(deck.deal());
				T4.add(deck.deal());
			}
			for (int i = 1; i <= 6; i++) {
				T5.add(deck.deal());
				T6.add(deck.deal());
				T7.add(deck.deal());
				T8.add(deck.deal());
			}
		}
	}
	
	
    /**
     * Tests the game for a winner
     * @return true if winner
     */
	public boolean winner() {
		if (HC1.size() == 13 && HC2.size() == 13 && HC3.size() == 13 && HC4.size() == 13) {
			return true;
		}
		else return false;
	}
	
	//unfinished//
	public String toString() {
		String s = "";
		System.out.println("This is a FreeCell Game. Stats:");
		s += "T1-- ";
		for (Card c1 : T1) {
			s += c1.toString() + ", ";
		}
		s += "T2-- ";
		for (Card c2 : T2) {
			s += c2.toString() + ", ";
		}
		s += "\n T3-- ";
		for (Card c3 : T3) {
			s += c3.toString() + ", ";
		}
		s += "\n T4-- ";
		for (Card c4 : T4) {
			s += c4.toString() + ", ";
		}
		s += "\n T5-- ";
		for (Card c5 : T5) {
			s += c5.toString() + ", ";
		}
		s += "\n T6-- ";
		for (Card c6 : T6) {
			s += c6.toString() + ", ";
		}
		s += "\n T7-- ";
		for (Card c7 : T7) {
			s += c7.toString() + ", ";
		}
		s += "\n T8-- ";
		for (Card c8 : T8) { 
			s += c8.toString() + ", ";
		}
		
		return s;
	}
}
