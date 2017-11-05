import java.util.ArrayList;
public class tester {

	public static void main(String[] args) {
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
		for (int i = 1; i < 8; i += 2) {
			Card c = new Card(Suit.club, i);
			Card d = new Card(Suit.heart, i+1);
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
	} 

}