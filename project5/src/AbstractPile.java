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
	
	public boolean canTransfer(Pile targetPile){
		if (targetPile instanceof HomeCellPile && !(this instanceof HomeCellPile))
		{
			Card c = getTop();
			//System.out.println(c.toString());
			if (targetPile.isEmpty())
			{
				if (c.getRank() == 1) return true;
				else return false;
			}
			Card targetPileCard = targetPile.getTop();
			Suit targetSuit = targetPileCard.getSuit();
			int targetRank = targetPileCard.getRank() + 1;
			Card targetCard = new Card(targetSuit, targetRank);
			//System.out.println(targetCard);
			if (c.compareTo(targetCard) == 0) return true;
			else return false;
		}
		else if((size() > 0) && (targetPile.size() < maxSize()) && !(this instanceof HomeCellPile)) return true;
		else return false;}
	
	public boolean transfer(Pile targetPile) {
		if (! canTransfer(targetPile)) return false;
		else{
			targetPile.add(remove());
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
