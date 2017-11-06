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
		FC1 = new FreeCellPile();
		FC2 = new FreeCellPile();
		FC3 = new FreeCellPile();
		FC4 = new FreeCellPile();
		HC1 = new HomeCellPile();
		HC2 = new HomeCellPile();
		HC3 = new HomeCellPile();
		HC4 = new HomeCellPile();
		T1 = new Tableau();
		T2 = new Tableau();
		T3 = new Tableau();
		T4 = new Tableau();
		T5 = new Tableau();
		T6 = new Tableau();
		T7 = new Tableau();
		T8 = new Tableau();
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
	
	public String toString() {
		String s = "";
		System.out.println("This is a FreeCell Game. Cell contents:");
		s += "T1-- " + T1.toString() + "\n";
		s += "T2-- " + T2.toString() + "\n";
		s += "T3-- " + T3.toString() + "\n";
		s += "T4-- " + T4.toString() + "\n";
		s += "T5-- " + T5.toString() + "\n";
		s += "T6-- " + T6.toString() + "\n";
		s += "T7-- " + T7.toString() + "\n";
		s += "T8-- " + T8.toString() + "\n";
		s += "FC1- " + FC1.toString() + "\n";
		s += "FC2- " + FC2.toString() + "\n";
		s += "FC3- " + FC3.toString() + "\n";
		s += "FC4- " + FC4.toString() + "\n";
		s += "HC1- " + HC1.toString() + "\n";
		s += "HC2- " + HC2.toString() + "\n";
		s += "HC3- " + HC3.toString() + "\n";
		s += "HC4- " + HC4.toString() + "\n";
		return s;
	}
}
