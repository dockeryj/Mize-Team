
/**
 * Represents a game of free cell
 * @author Roby Mize
 *
 */


public class FreeCellGame {
	
	private FreeCellPile FC1;
	private FreeCellPile FC2;
	private FreeCellPile FC3;
	private FreeCellPile FC4;
	private HomeCellPile HC1;
	private HomeCellPile HC2;
	private HomeCellPile HC3;
	private HomeCellPile HC4;
	private Tableau T1;
	private Tableau T2;
	private Tableau T3;
	private Tableau T4;
	private Tableau T5;
	private Tableau T6;
	private Tableau T7;
	private Tableau T8;
	private Deck deck;
	
	
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
	
	public boolean winner() {
		if (HC1.size() == 13 && HC2.size() == 13 && HC3.size() == 13 && HC4.size() == 13) {
			return true;
		}
		else return false;
	}
	
}
