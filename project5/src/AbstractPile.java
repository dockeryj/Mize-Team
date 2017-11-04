/**
 * Forms the basis of all piles in the freecell game
 * @author Chris Surran
 *
 */
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPile implements Pile, Iterable<Card>
{
	
	private List<Card> abstractPile;
	private int maxSize; 
	
	public AbstractPile(int size)
	{
		abstractPile = new ArrayList<Card>();
		this.maxSize = size;
	}
	
	public int size(){ 
		return abstractPile.size();}
	
	public int maxSize() {
		return maxSize;}
	
	public void clear(){
		abstractPile = new ArrayList<Card>();}
	
	public void add(Card cardToBeAdded){
		abstractPile.add(cardToBeAdded);}
	
	public Card remove() {
		return (Card)abstractPile.remove(abstractPile.size() - 1);}
	
	public boolean canTransfer(Pile targetPile){
		if((size() < maxSize()) && (targetPile.size() < maxSize())) return true;
		else return false;}
	
	public boolean transfer(Pile targetPile) {
		if (! canTransfer(targetPile)) return false;
		else{
			abstractPile.add(targetPile.remove());
			return true;
		}
	
	}
	
	
}