
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
		
	}
	
	
}
