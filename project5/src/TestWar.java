

/**
 * Tests the WarGame Class
 * @author Roby
 *
 */

public class TestWar {

	public static void main(String[] args) {
		WarGame game = new WarGame();
		game.deal();
		while (game.winner() == null) {
			game.step();
			System.out.println(game.toString());
		}
		System.out.println(game.winner());
	}

}
