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
    private ArrayList<CardPanel> tableaux1 = new ArrayList<CardPanel>();
    private ArrayList<CardPanel> tableaux2 = new ArrayList<CardPanel>();
	private ArrayList<CardPanel> homeCells = new ArrayList<CardPanel>();
	private ArrayList<CardPanel> freeCells = new ArrayList<CardPanel>();
	private FreeCellGame freeCellGame = new FreeCellGame();
   
	public AppView(FreeCellGame freeCellGame)
	{
    		//Set the title of the window
        this.setTitle("FreeCell");
        
        freeCellGame.reset();
     
        
        for(int i = 0; i < 4; i++) {
			homeCells.add(new CardPanel());
			freeCells.add(new CardPanel());
			tableaux1.add(new CardPanel());
			tableaux2.add(new CardPanel());
		}
        
        
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
      
        
        // Create Card panels (may need to figure out how to pin free cells and home cells to the top?)
        JPanel freePanel = new JPanel();
        freePanel.setLayout(new GridLayout(1,4));
        
        JPanel homePanel = new JPanel();
        homePanel.setLayout(new GridLayout(1,4));
            
        JPanel tableauPanel1 = new JPanel();
        tableauPanel1.setLayout(new GridLayout(1,4));
        
        JPanel tableauPanel2 = new JPanel();
        tableauPanel2.setLayout(new GridLayout(1,4));
        
        
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2,2));
        
        for (CardPanel i : homeCells) {
        		homePanel.add(i);
        }
        for (CardPanel i : freeCells) {
        		freePanel.add(i);	  	
        }
        for (CardPanel i : tableaux1) {
    			tableauPanel1.add(i);
        }
        for (CardPanel i : tableaux2) {
			tableauPanel2.add(i);
			
        }
        
      
        //add card panels to center panel
        centerPanel.setBackground(new Color(51, 102, 0));
        centerPanel.add(freePanel);    
        centerPanel.add(homePanel); 
        centerPanel.add(tableauPanel1);
        centerPanel.add(tableauPanel2);
        
       
        // Create the South Panel
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(0,1));
        southPanel.add(newGameButton);
        
        // Add JPanes to the mainPane
        mainContainer.setBackground(new Color(51, 102, 0));
        mainContainer.add(centerPanel, BorderLayout.CENTER);
        mainContainer.add(southPanel, BorderLayout.SOUTH);
        mainContainer.add(northPanel,BorderLayout.NORTH);   
        
        //adds listeners to buttons
        //newGameButton.addActionListener(new NewGameListener());
        
    }

	private class NewGameListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			
		}
	}
    
}
