import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * The main window for dealing from a deck of cards.
 * @author Chris_Surran, Taylor_Dockery, Roby Mize, Cooper Breithaupt
 *
 */
public class MainView extends JFrame{

    private JPanel gameStatsLabelPanel = new JPanel();
    private JButton moveButton = new JButton("Move");
    private JButton newGameButton = new JButton("New Game");
    private Container mainContainer = getContentPane();
    private JTextArea statsField = new JTextArea();
    private CardPanel p1Card = new CardPanel();
    private CardPanel p2Card = new CardPanel();
	private WarGame model;
    
    public MainView(WarGame model){
        this.model = model;
        this.setTitle("Game of War");
        
        // Create the north panel of our border layout
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        
        c.weightx = .5;
        c.gridx = 0;
        c.gridy = 0;
        JPanel playerOneLabelPanel = new JPanel();
        playerOneLabelPanel.add(new JLabel("Player 1"), BorderLayout.CENTER);
        northPanel.add(playerOneLabelPanel, c);
        
        c.gridx = 1;
        c.gridy = 0;
        gameStatsLabelPanel.add(new JLabel("Game Stats"), BorderLayout.CENTER);
        northPanel.add(gameStatsLabelPanel, c);
        
        c.gridx = 2;
        c.gridy = 0;
        JPanel playerTwoLabelPanel = new JPanel();
        playerTwoLabelPanel.add(new JLabel("Player 2"), BorderLayout.CENTER);
        northPanel.add(playerTwoLabelPanel, c);
       
        // Create Center Panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(0,3));
        centerPanel.add(p1Card);
        statsField.setEnabled(false);
        centerPanel.add(statsField);
        centerPanel.add(p2Card);
        
        // Create the South Panel
        JPanel southPanel = new JPanel();
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
			ArrayList<Card> playerCards = new ArrayList<>();
			playerCards.addAll(model.step());
			Card player1Card = playerCards.get(0);
			player1Card.turn();
			Card player2Card = playerCards.get(1);
			player2Card.turn();
			p1Card.setCard(player1Card);
			p2Card.setCard(player2Card);
			statsField.setText(model.toString());
			if (model.winner() == 1)
			{
				JOptionPane.showMessageDialog(null, "Player One Won!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
			}
			if (model.winner() == 2)
			{
				JOptionPane.showMessageDialog(null, "Player Two Won!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
			}
			if (model.winner() == 0)
			{
				JOptionPane.showMessageDialog(null, "The Game Ended in a Tie!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
			}
			
			
		}
		
	}
	
	private class NewGameListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			model = new WarGame();
			statsField.setText(model.toString());
			p1Card.setCard(null);
			p2Card.setCard(null);
			
			
		}
	}
    
}
