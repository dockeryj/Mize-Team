

/**
 * Tests the WarGame Class
 * @author Roby
 *
 */

public class TestWar {

	public static void main(String[] args) {
		WarGame game = new WarGame();
		while (game.winner() == -1) {
			game.step();
			System.out.println(game.toString());
		}
		System.out.println(game.winner());
	}

}
