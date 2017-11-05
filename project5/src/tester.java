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
		
		
		
	} 

}