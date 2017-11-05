public class tester {

	public static void main(String[] args) {
		FreeCellPile cell = new FreeCellPile();
		FreeCellPile cell3 = new FreeCellPile();
		HomeCellPile cell2 = new HomeCellPile();
		for (int i = 1; i < 14; i++) 
			{
			Card c = new Card(Suit.club, i);
			cell.add(c);
			System.out.println(cell2.transfer(cell));
			}
//		System.out.println(cell2);
//		HomeCellPile cell3 = new HomeCellPile();
//		Card c = new Card(Suit.club, 2);
//		cell.add(c);
//		System.out.println(cell);
		System.out.println(cell.canTransfer(cell2));
		
	}

}