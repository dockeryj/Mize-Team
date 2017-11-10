import java.awt.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

public class MultiCardPanel extends CardPanel{

	private Card card;
	
	public MultiCardPanel(List<Card> cards, Graphics g) {
		int length = cards.size();
		for (int i = 0; i < length; i++) {
			//create the panel for the cards
		}
		for (int i = 0; i<=length; i++) {
			card = cards.get(i);
			this.setCard(card);
			//add the cards to the panel
		}
			
	}
}
