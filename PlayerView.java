import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerView extends JPanel {
	
	private JLabel nameLabel;

	public PlayerView(Player player, boolean isDealer) {
		
		this.setOpaque(false);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		if(!isDealer) {
			JLabel playerName = new JLabel(player.getName());
			playerName.setForeground(Color.white);
	        
			JPanel namePanel = new JPanel(new GridLayout(1,1,5,5));
	        namePanel.setBackground(Color.decode("#353535"));
	        namePanel.add(playerName);
	        
	        this.add(namePanel);
		}
        
        JPanel playingArea = new JPanel();
        playingArea.setOpaque(false);
		
		for(int i = 0; i < player.getHands().size(); i++) {
        	Hand hand = player.getHands().get(i);
        	
        	JPanel playerHand = new JPanel();
        	playerHand.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        	playerHand.setOpaque(false);
        	
        	JPanel cardsArea = new JPanel(new GridLayout(1, hand.getCards().size(), 5, 5));
        	cardsArea.setOpaque(false);
        	
        	JPanel buttonsArea = null;
        	if(!isDealer) {
	        	buttonsArea = new JPanel(new GridLayout(2, 1, 5, 5));
	        	buttonsArea.setOpaque(false);
	            JButton hitBtn = new JButton("HIT");
	            JButton standBtn = new JButton("STAND");
	            hitBtn.setBackground(Color.WHITE);
	            hitBtn.setForeground(Color.GRAY);
	            
	            standBtn.setBackground(Color.WHITE);
	            standBtn.setForeground(Color.GRAY);
	            buttonsArea.add(hitBtn);
	            buttonsArea.add(standBtn);
        	}
//            btnTest.addActionListener(this);

            for(int j = 0; j < hand.getCards().size(); j++) {
            	boolean flipcard = false;
            	if(isDealer && j <= 0) {
            		flipcard = true;
            	}
            	cardsArea.add(addCard(hand.getCards().get(j),flipcard));
            }
            
            playerHand.add(cardsArea);
            if(!isDealer) {
            	playerHand.add(buttonsArea);
            }
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
	
	public JLabel addCard(Card card, boolean flipCard) {
		
		String imagePath = "./images/" + card.getImage();
		if(flipCard) {
			if(card.getType().equals("heart") || card.getType().equals("diamond")) {
				imagePath = "./images/red.png";
			} else {				
				imagePath = "./images/black.png";
			}
		}
		
        ImageIcon icon = new ImageIcon(imagePath);
        
        JLabel cardLabel = new JLabel();
        cardLabel.setIcon(icon);
        cardLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        return cardLabel;
	}
	
}
