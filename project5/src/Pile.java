import java.util.Iterator;
public interface Pile {
	public abstract String toString();
	public abstract int size(); //
	public abstract int maxSize();
	public abstract void clear(); //
	public abstract void add(Card cardToBeAdded); //
	public abstract Card remove(); //
	public abstract boolean transfer(Pile targetPile); //
	public abstract boolean canTransfer(Pile targetPile); //
	public abstract boolean isEmpty();
	public abstract Iterator<Card> iterator(); // This is because we will need to iterate through pile to display gui
}
