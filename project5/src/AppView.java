//instantiates the model and the view. Needs a NEW GAME button and listener
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * The main window for dealing from a deck of cards.
 * @author Chris_Surran, Taylor_Dockery, Roby Mize, Cooper Breithaupt
 *
 */
public class AppView extends JFrame{

    private JPanel cellLabel = new JPanel();
    private JButton moveButton = new JButton("Move");
    private JButton newGameButton = new JButton("New Game");
    private Container mainContainer = getContentPane();
    private CardPanel T1 = new CardPanel();
    private CardPanel T2 = new CardPanel();
    private CardPanel T3 = new CardPanel();
    private CardPanel T4 = new CardPanel();
    private CardPanel T5 = new CardPanel();
    private CardPanel T6 = new CardPanel();
    private CardPanel T7 = new CardPanel();
    private CardPanel T8 = new CardPanel();
    private CardPanel H1 = new CardPanel();
    private CardPanel H2 = new CardPanel();
    private CardPanel H3 = new CardPanel();
    private CardPanel H4 = new CardPanel();
    private CardPanel F1 = new CardPanel();
    private CardPanel F2 = new CardPanel();
    private CardPanel F3 = new CardPanel();
    private CardPanel F4 = new CardPanel();
    
	private FreeCellGame model;
    
    public AppView(FreeCellGame model){
        this.model = model;
        this.setTitle("FreeCell");
        
        // Create the north panel of our border layout
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        
        c.weightx = .5;
        c.gridx = 0;
        c.gridy = 0;
        JPanel homeCellLabel = new JPanel();
        homeCellLabel.add(new JLabel("Free Cells"), BorderLayout.CENTER);
        northPanel.add(homeCellLabel, c);
        
        
        c.gridx = 1;
        c.gridy = 0;
        JPanel freeLabelPanel = new JPanel();
        freeLabelPanel.add(new JLabel("Home Cells"), BorderLayout.CENTER);
        northPanel.add(freeLabelPanel, c);
      
        
        // Create Cards
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1,8));
        centerPanel.add(F1);
        centerPanel.add(F1);
        centerPanel.add(F2);
        centerPanel.add(F3);
        centerPanel.add(F4);
        centerPanel.add(H1);
        centerPanel.add(H2);
        centerPanel.add(H3);
        centerPanel.add(H4);
        
        JPanel tableauPanel = new JPanel();
        tableauPanel.setLayout(new GridLayout());
        tableauPanel.add(T1);
        tableauPanel.add(T2);
        tableauPanel.add(T3);
        tableauPanel.add(T4);
        tableauPanel.add(T5);
        tableauPanel.add(T6);
        tableauPanel.add(T7);
        tableauPanel.add(T8);
        
       
        
        // Create the South Panel
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(0,1));
        southPanel.add(newGameButton);
      
        // Add JPanes to the mainPane
        mainContainer.add(centerPanel, BorderLayout.CENTER);
        mainContainer.add(southPanel, BorderLayout.SOUTH);
        mainContainer.add(northPanel,BorderLayout.NORTH);   
        
        //adds listeners to buttons
        newGameButton.addActionListener(new NewGameListener());
        
    }

	private class NewGameListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		
			
		}
	}
    
}
