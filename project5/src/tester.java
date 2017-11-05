import java.util.ArrayList;
public class tester {

	public static void main(String[] args) {
		FreeCellPile cell = new FreeCellPile();
		FreeCellPile cell3 = new FreeCellPile();
		HomeCellPile cell2 = new HomeCellPile();
		Tableau t1 = new Tableau();
		for (int i = 1; i < 14; i++) 
			{
			Card c = new Card(Suit.club, i);
			t1.add(c);
			System.out.println(cell2.transfer(cell));
			}
		ArrayList<Card> cardsToCheck = new ArrayList<>();
		for (Card c: t1) cardsToCheck.add(c);
		
		
		
	}

}