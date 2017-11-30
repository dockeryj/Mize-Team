import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


/**
 * The main window for dealing from a deck of cards.
 * @author Chris_Surran, Taylor_Dockery, Roby_Mize, Cooper_Breithaupt
 *
 */
public class AppView extends JFrame{
    private JButton newGameButton = new JButton("New Game");
    private Container mainContainer = getContentPane();
    private ArrayList<MultiPilePanel> tableaux1 = new ArrayList<>();
    private ArrayList<MultiPilePanel> tableaux2 = new ArrayList<>();
	private ArrayList<SinglePilePanel> freeCells = new ArrayList<>();
	private ArrayList<SinglePilePanel> homeCells = new ArrayList<>();
	private FreeCellGame model;
	private ViewInformer informer;
	private AbstractPilePanel sourcePanel;
	
	public AppView(FreeCellGame freeCellGame){
		
    		//Set the title of the window
        this.setTitle("FreeCell");
        //System.out.println(freeCellGame); USED FOR TESTING
        
        //Create the model
        model = freeCellGame;
        informer = new ViewInformer();
        
        
        // Fill the panels with the piles from the model
        for(int i = 1; i < 5; i++) {
			homeCells.add(new SinglePilePanel(freeCellGame.getHomePile(i), informer));
			freeCells.add(new SinglePilePanel(freeCellGame.getFreePile(i), informer));
			tableaux1.add(new MultiPilePanel(freeCellGame.getTableau(i), informer));
			tableaux2.add(new MultiPilePanel(freeCellGame.getTableau(i + 4), informer));
		}
        
        // Create the north panel of border layout. Contains labels for Home/Free Cells
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(1,0,30,0)); //30 Helps put Home Cells label in right place
        northPanel.add(new JLabel("Free Cells"));
        northPanel.add(new JLabel("Home Cells"));
        
      
        
        // Create the panels for all pile types
        JPanel freePanel = new JPanel();
        freePanel.setLayout(new GridLayout(1,4));
        
        JPanel homePanel = new JPanel();
        homePanel.setLayout(new GridLayout(1,4));
            
        JPanel tableauPanel1 = new JPanel();
        tableauPanel1.setLayout(new GridLayout(1,4));
        
        JPanel tableauPanel2 = new JPanel();
        tableauPanel2.setLayout(new GridLayout(1,4));
        
        
        // Add all card piles to their respective panels
        for (SinglePilePanel i : homeCells) {
        		homePanel.add(i);
        }
        for (SinglePilePanel i : freeCells) {
        		freePanel.add(i);	  	
        }
        for (MultiPilePanel i : tableaux1) {
    			tableauPanel1.add(i);
        }
        for (MultiPilePanel i : tableaux2) {
			tableauPanel2.add(i);
        }
        
        for(SinglePilePanel i : homeCells) {
        		i.addMouseListener(new CardMoveListener(i));
        }
        
        for(SinglePilePanel i : freeCells) {
        		i.addMouseListener(new CardMoveListener(i));		
        }
        
        for(MultiPilePanel i : tableaux1) {
        		i.addMouseListener(new CardMoveListener(i));
        }
        
        for(MultiPilePanel i : tableaux2) {
        		i.addMouseListener(new CardMoveListener(i));
        }
        
        // Create center panel and add cards to it. 
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2,2));
        centerPanel.setBackground(new Color(51, 102, 0));
        centerPanel.add(freePanel);    
        centerPanel.add(homePanel); 
        centerPanel.add(tableauPanel1);
        centerPanel.add(tableauPanel2);
        
       
        // Create the south panel which contains the new game button
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(0,1));
        southPanel.add(newGameButton);
        newGameButton.addActionListener(new NewGameListener());
        
        
        // Add north south and center panel to border layout (main container)
        mainContainer.setBackground(new Color(51, 102, 0));
        mainContainer.add(centerPanel, BorderLayout.CENTER);
        mainContainer.add(southPanel, BorderLayout.SOUTH);
        mainContainer.add(northPanel,BorderLayout.NORTH);
	}
	
	/**
	 * Controller for the game model
	 */
	public class ViewInformer{
		private ViewInformer(){
		}
		public void PanelPressed(AbstractPilePanel i){
			if (sourcePanel == null) {
				sourcePanel = i;
			}
			else {
				model.move(sourcePanel.getCell(), i.getCell());
				repaint();
				sourcePanel = null;
			}
		}
	}
	/**
	 * simple button listener that creates a new game when called upon
	 */
	private class NewGameListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		model.reset();
		//System.out.println(model);
		repaint();
		}
	}
	/**
	 * Creates the listener for the mouse click
	 */
	public class CardMoveListener implements MouseListener{
		private AbstractPilePanel currentPanel;
		private CardMoveListener(AbstractPilePanel i) {
			currentPanel = i;
		}
	
		public void mouseClicked(MouseEvent e) {
			informer.PanelPressed(currentPanel);
			System.out.println("CurrentPanel: " + currentPanel + "sourcePanel: " +sourcePanel);
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}


