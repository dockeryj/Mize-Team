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
	
	public int size(){ 
		return abstractPile.size();}
	
	public void clear(){
		abstractPile = new ArrayList<Card>();}
	
	public void add(Card cardToBeAdded){
		abstractPile.add(cardToBeAdded);}
	
	public Card remove() {
		return (Card)abstractPile.remove(abstractPile.size() - 1);}
	
	public boolean transfer(Pile targetPile) {
		if 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}