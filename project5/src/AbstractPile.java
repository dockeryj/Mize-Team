/**
 * Forms the basis of all piles in the freecell game
 * @author Chris Surran
 *
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

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
	
	public int maxSize(){ 
		return maxSize;}
	
	public void clear(){
		abstractPile = new ArrayList<Card>();}
	
	public void add(Card cardToBeAdded){
		abstractPile.add(cardToBeAdded);}
	
	public Card getTop(){
		if (isEmpty()) throw new IllegalStateException("Cell is Empty");
		return (Card)abstractPile.get(abstractPile.size() - 1);
	}
	
	public Card remove() {
		if (isEmpty()) throw new IllegalStateException("Cannot remove from an empty stack.");
		return (Card)abstractPile.remove(abstractPile.size() - 1);}
	
	public boolean canTransfer(Pile sourcePile) {
		return((size() < maxSize()) && (!sourcePile.isEmpty()) && (!(sourcePile instanceof HomeCellPile)));}
	public boolean transfer(Pile sourcePile) {
		if (! canTransfer(sourcePile)) return false;
		else{
			abstractPile.add(sourcePile.remove());
			return true;
		}
	}
	public boolean isEmpty() {
		return abstractPile.isEmpty();}
	
	public Iterator<Card> iterator(){
		return abstractPile.iterator();}
	
	public String toString(){
		String s = "";
		for (Card c: abstractPile)
		{
			s+= (c.toString() + "\n");
		}
		return s; 
	}
}
