import javax.management.modelmbean.ModelMBean;

/**
 * A tester program for the game
 * @author Roby Mize
 * @author Taylor Dockery
 */

public class tester {

	public static void main(String[] args) {
		FreeCellGame game = new FreeCellGame();
		FreeCellPile freeCell = new FreeCellPile();
		HomeCellPile homeCell = new HomeCellPile();
		for (int i = 1; i < 14; i++) 
			{
			Card c = new Card(Suit.club, i);
			freeCell.add(c);
			System.out.println(homeCell.transfer(freeCell));
			}
		System.out.println(homeCell.transfer(freeCell));
		//Testing inOrder
		System.out.println("Adding the following to ordered Tableau:");
		Tableau tableau = new Tableau();
		for (int i = 8; i > 0; i -= 2) {
			Card c = new Card(Suit.club, i);
			Card d = new Card(Suit.heart, i-1);
			tableau.add(c);
			tableau.add(d);
			System.out.println(c.toString());
			System.out.println(d.toString());
		}
		
		System.out.println("Adding the following to unordered Tableau:");
		Tableau tableau2 = new Tableau();
		for (int i = 1; i < 8; i += 2) {
			Card c = new Card(Suit.club, i);
			Card d = new Card(Suit.spade, i+1);
			tableau2.add(c);
			tableau2.add(d);
			System.out.println(c.toString());
			System.out.println(d.toString());
		}
		System.out.println("Adding the following to unordered Tableau:");
		Tableau tableau3 = new Tableau();
		for (int i = 1; i < 8; i += 4) {
			Card c = new Card(Suit.club, i);
			Card d = new Card(Suit.heart, i+2);
			tableau3.add(c);
			tableau3.add(d);
			System.out.println(c.toString());
			System.out.println(d.toString());
		}
		System.out.println("Testing inOrder");
		System.out.println("Expect True: " + tableau.inOrder(0, 2));
		System.out.println("Expect False: " + tableau2.inOrder(0, 7));
		System.out.println("Expect False: " + tableau3.inOrder(0, 2));
		//Testing transfering multiple cards between tableau
		Tableau tableau4 = new Tableau();
		Tableau tableau5 = new Tableau();
		Card c = new Card(Suit.club, 13);
		tableau4.add(c);
		Card d = new Card(Suit.heart, 12);
		Card e = new Card(Suit.club, 11);
		Card f = new Card(Suit.heart, 10);
		tableau5.add(d);
		tableau5.add(e);
		tableau5.add(f);
		
		System.out.println("Tableau 4: \n" + tableau4);
		System.out.println("Tableau 5: \n" + tableau5);

		tableau4.transfer(tableau5);
		System.out.println("Tableau 4 after transfer: \n" + tableau4);
		System.out.println("Tableau 5 after transfer (Expect empty): \n" + tableau5);
		Card g = new Card(Suit.club, 2);
		tableau5.add(g);
		tableau4.transfer(tableau5);
		System.out.println("Tableau 4 after transfer: \n" + tableau4);
		System.out.println("Tableau 5 after transfer (Expect 2 of clubs): \n" + tableau5);
		tableau5.transfer(tableau4);
		System.out.println("Tableau 4 after transfer: \n" + tableau4);
		System.out.println("Tableau 5 after transfer (Expect 2 of clubs): \n" + tableau5);
		
		
		System.out.println("\nTesting game.toString()");
		System.out.println(game.toString());
		
		
		System.out.println(game.hasMoreMoves());
		
		
		System.out.println("_________Test Complete__________");
	} 

}