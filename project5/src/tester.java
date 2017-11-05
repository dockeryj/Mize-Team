public class tester {

	public static void main(String[] args) {
		FreeCellPile cell = new FreeCellPile();
		HomeCellPile cell2 = new HomeCellPile();
		for (int i = 1; i < 14; i++) 
			{
			Card c = new Card(Suit.club, i);
			cell.add(c);
			System.out.println(cell.transfer(cell2));
			}
		System.out.println(cell2);
		HomeCellPile cell3 = new HomeCellPile();
		
	}

}