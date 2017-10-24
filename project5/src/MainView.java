import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The main window for dealing from a deck of cards.
 * @author Chris_Surran, Taylor_Dockery
 *
 */
public class MainView extends JFrame{

    private WarGame model;
    private JPanel northPanel = new JPanel();
    private JPanel playerOneLabelPanel = new JPanel();
    private JPanel gameStatsLabelPanel = new JPanel();
    private JPanel playerTwoLabelPanel = new JPanel();
    private JPanel centerPanel = new JPanel();
    private JPanel southPanel = new JPanel();
    private JButton moveButton = new JButton("Move");
    private JButton newGameButton = new JButton("New Game");
    private Container mainContainer = getContentPane();
    private JTextField statsField = new JTextField("");
    
    public MainView(WarGame model){
        this.model = model;
        this.setTitle("Game of War");
        
        // Create the north panel of our border layout
        northPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = .5;
        c.gridx = 0;
        c.gridy = 0;
        playerOneLabelPanel.add(new JLabel("Player 1"), BorderLayout.CENTER);
        northPanel.add(playerOneLabelPanel, c);
        
        c.gridx = 1;
        c.gridy = 0;
        gameStatsLabelPanel.add(new JLabel("Game Stats"), BorderLayout.CENTER);
        northPanel.add(gameStatsLabelPanel, c);
       
        c.gridx = 2;
        c.gridy = 0;
        playerTwoLabelPanel.add(new JLabel("Player 2"), BorderLayout.CENTER);
        northPanel.add(playerTwoLabelPanel, c);
       
        // Create Center Panel
        centerPanel.setLayout(new GridLayout(0,3));
        centerPanel.add(new CardPanel());
        centerPanel.add(statsField);
        centerPanel.add(new CardPanel());
        
       
        // Create the South Panel
        southPanel.add(moveButton);
        southPanel.add(newGameButton);
      
        // Add JPanes to the mainPane
        mainContainer.add(centerPanel, BorderLayout.CENTER);
        mainContainer.add(southPanel, BorderLayout.SOUTH);
        mainContainer.add(northPanel,BorderLayout.NORTH);   
        
        //adds listeners to buttons
        moveButton.addActionListener(new MoveListener());
        newGameButton.addActionListener(new NewGameListener());
        
    }
    private class MoveListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			model.step();
			statsField.setText(model.toString());
			
		}
	}
	
	private class NewGameListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			model.step();
		}
	}
    
}
