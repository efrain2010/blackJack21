import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BoardView extends JFrame implements ActionListener {
    
	private Model objectModel;
	
    public BoardView(Model objectModel) {
    	this.objectModel = objectModel;
    }
    
    public void setBoard(Player dealer, ArrayList<Player> players) {
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setTitle("Blackjack 21");
        this.setSize(995, 579);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel masterPanel = new JPanel();
        masterPanel.setBackground(Color.decode("#007639"));
        masterPanel.setLayout(new GridLayout(0, 1, 0, 0));
        
        JPanel topPanel = new JPanel();
        topPanel.setOpaque(false);
        topPanel.setLayout(new GridLayout(1, 1, 0, 0));
        
        PlayerView dealerView = new PlayerView(dealer, true);
        topPanel.add(dealerView);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setOpaque(false);
        bottomPanel.setLayout(new GridLayout(1, players.size(), 0, 0));
        
        for(int i = 0; i < players.size(); i++) {
        	
        	Player player = players.get(i);
        	
        	PlayerView pleayerView = new PlayerView(player, false);
        	bottomPanel.add(pleayerView);
        }
        
        masterPanel.add(topPanel);
        masterPanel.add(bottomPanel);

        getContentPane().add(masterPanel);
    }

    public void actionPerformed(ActionEvent e) {
    	System.out.println(e);
    }

}