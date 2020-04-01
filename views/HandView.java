package views;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import blackjack.Card;
import blackjack.Hand;
import blackjack.Player;

public class HandView extends JPanel {
	
	private JLabel nameLabel;
	private ArrayList<JLayeredPane> playerHandPanel = new ArrayList<JLayeredPane>();

	public HandView(Player player) {
		
		this.setOpaque(false);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS));
		namePanel.setOpaque(false);
		
		this.nameLabel = new JLabel(player.getName() + " - " + player.getHands().get(0).getCardsPoints(player, true), SwingConstants.CENTER);
		this.nameLabel.setForeground(Color.white);
		this.nameLabel.setBackground(Color.decode("#353535"));
		this.nameLabel.setFont(new Font("Courrier New", Font.BOLD, 16));
        namePanel.add(this.nameLabel);
		
		this.add(namePanel, BorderLayout.CENTER);
        
        JPanel playingArea = new JPanel();
        playingArea.setOpaque(false);
		
		for(int i = 0; i < player.getHands().size(); i++) {
        	Hand hand = player.getHands().get(i);
        	
        	JPanel playerHand = new JPanel();
        	playerHand.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        	playerHand.setOpaque(false);
        	
        	JPanel cardsArea = new JPanel(new BorderLayout());
        	cardsArea.setOpaque(false);
        	JLayeredPane layeredPane = new JLayeredPane();
        	layeredPane.setPreferredSize(new Dimension(100 * hand.getCards().size(), (int) (100*1.38)));
        	layeredPane.setLocation(100, 0);
        	layeredPane.setOpaque(false);
        	
        	int count = 0;
            for(int j = 0; j < hand.getCards().size(); j++) {
            	boolean flipcard = false;
            	if(player.isDealer() && j <= 0) {
            		flipcard = true;
            	}
            	layeredPane.add(addCard(hand.getCards().get(j), flipcard, count++), BorderLayout.CENTER);
            }
            this.playerHandPanel.add(layeredPane);
            cardsArea.add(layeredPane);
            playerHand.add(cardsArea);
            playingArea.add(playerHand);
            
        }
		
		this.add(playingArea);
		
	}
	
	public JLabel getNameLabel() {
		return this.nameLabel;
	}
	
	public void setNameLabel(JLabel nameLabel) {
		this.nameLabel = nameLabel;
	}
	
	public JLayeredPane getPlayerHandPanel(int numOfHand) {
		return this.playerHandPanel.get(numOfHand);
	}
	
	public JLabel addCard(Card card, boolean flipCard, int count) {
		
		String imagePath = "./images/" + card.getImage();
		if(flipCard) {
			if(card.getType().equals("heart") || card.getType().equals("diamond")) {
				imagePath = "./images/red.png";
			} else {				
				imagePath = "./images/black.png";
			}
		}
		
		int imageWidth = 100, imageHeight = (int) (imageWidth * 1.38);
		
		ImageIcon background = new ImageIcon(imagePath);
		Image img = background.getImage();
		Image temp = img.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
		background = new ImageIcon(temp);
		
        JLabel cardLabel = new JLabel(background);
        cardLabel.setBounds(18*count, 0, imageWidth, imageHeight);
        
        return cardLabel;
	}
	
	public void updatePlayerPoints(Player player) {
		if(player.getHands().size() == 1) {
			int sum = player.getHands().get(0).getCardsPoints(player, false);
			this.nameLabel.setText(player.getName() + " - " + sum);
		}
	}
	
}
