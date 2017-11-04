/**
 * Forms the basis of all piles in the freecell game
 * @author Chris Surran
 *
 */
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPile implements Pile, Iterable<Card>{
	
	private List<Card> abstractPile;
	
	public AbstractPile(int size)
	{
		abstractPile = new ArrayList<Card>();
	}
	
	
	
	
	
	
	
}