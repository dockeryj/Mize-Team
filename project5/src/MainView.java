import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The main window for dealing from a deck of cards.
 * @author lambertk
 *
 */
public class MainView extends JFrame{

    private Deck deck;

    public MainView(Deck deck){
        this.deck = deck;
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
        JPanel gameStatsLabelPanel = new JPanel();
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
        centerPanel.add(new CardPanel());
        centerPanel.add(new JTextField(""));
        centerPanel.add(new CardPanel());
       
        // Create the South Panel
        JPanel southPanel = new JPanel();
        JButton moveButton = new JButton("Move");
        JButton newGameButton = new JButton("New Game");
        southPanel.add(moveButton);
        southPanel.add(newGameButton);
      
        // Add JPanes to the mainPane
        Container mainContainer = getContentPane();
        mainContainer.add(centerPanel, BorderLayout.CENTER);
        mainContainer.add(southPanel, BorderLayout.SOUTH);
        mainContainer.add(northPanel,BorderLayout.NORTH);   
    }
}
