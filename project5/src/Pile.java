import java.util.Iterator;
public interface Pile {
	public abstract String toString();
	public abstract int size(); 
	public abstract int maxSize(); 
	public abstract Card getTop(); 
	public abstract void clear(); 
	public abstract void add(Card cardToBeAdded); 
	public abstract Card remove(); 
	public abstract Card remove(int i);
	public abstract boolean transfer(Pile sourcePile); 
	public abstract boolean canTransfer(Pile sourcePile); 
	public abstract boolean isEmpty(); 
	public abstract Iterator<Card> iterator(); 
	public abstract boolean inOrder(int low, int high);
	public abstract Card get(int i);
	
}
