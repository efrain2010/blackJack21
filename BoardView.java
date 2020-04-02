import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BoardView extends JFrame {
    
	private Controller controllerObject;
	private Player player;
	
	private ControlsMenuView controls;
	private ArrayList<HandView> playersView;
	private HandView dealerView;
	private BetView betView;
	private JPanel masterPanel;
	
    public BoardView(Controller controllerObject) {
    	this.controllerObject = controllerObject;
    	this.playersView = new ArrayList<HandView>();
    }
    
    public ControlsMenuView getControls() {
    	return this.controls;
    }
    
    public BetView getBetView() {
    	return this.betView;
    }
    
    public static String initWindow() {
    	return JOptionPane.showInputDialog(new JFrame(), "What's your name?");
    }
    
    public void setBoard() {
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    	this.setTitle("Blackjack 21");
        this.setSize(650, 480);  
        this.setLocationRelativeTo(null);
        
        
        this.masterPanel = new JPanel();
        this.masterPanel.setBackground(Color.decode("#007639"));
        this.masterPanel.setLayout(new BorderLayout());
        
        this.betView = new BetView(this.controllerObject);
        this.masterPanel.add(this.betView);
        
//        this.dealCards(this.controllerObject.getBoard().getDealer(), this.controllerObject.getBoard().getPlayers());
        
        this.add(this.masterPanel);
    }
    
    public void dealCards() {
    	
    	this.betView.setVisible(false);
        
        JPanel topPanel = new JPanel();
        topPanel.setOpaque(false);
        topPanel.setLayout(new GridLayout(1, 1, 0, 0));
        topPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        
        this.dealerView = new HandView(this.controllerObject.getBoard().getDealer());
        topPanel.add(this.dealerView);
        
        ArrayList<Player> players = this.controllerObject.getBoard().getPlayers();

        JPanel bottomPanel = new JPanel();
        bottomPanel.setOpaque(false);
        bottomPanel.setLayout(new GridLayout(1, players.size(), 0, 0));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        
        for(int i = 0; i < players.size(); i++) {
        	Player player = players.get(i);
        	
        	HandView pleayerView = new HandView(player);
        	bottomPanel.add(pleayerView);
        	this.playersView.add(pleayerView);
        }
        
        this.controls = new ControlsMenuView(this.controllerObject);
        
        this.masterPanel.add("North", topPanel);
        this.masterPanel.add("Center", bottomPanel);
        this.masterPanel.add("South", this.controls);
    }
    
    public void giveCard(int playerNumber, Card newCard) {
    	int numOfCards = this.controllerObject.getBoard().getPlayers().get(playerNumber).getHands().get(0).getCards().size();
    	JLabel newCrad = this.playersView.get(playerNumber).addCard(newCard, false, numOfCards-1);
    	this.playersView.get(playerNumber).getPlayerHandPanel(0).add(newCrad);
    	this.playersView.get(playerNumber).updatePlayerPoints(this.controllerObject.getBoard().getPlayers().get(playerNumber));
    }
    
    public void addPlayerBet(int betQuantity, int totalBet) {
    	this.betView.addBet(betQuantity, totalBet);
    }
    
    public void removePlayerBet(int lastBet, int playerStakes, int playerActualBet) {
    	this.betView.removeBet(lastBet, playerStakes, playerActualBet);
    }
    
    public void updatePlayBet(int betQuantity, int totalBet) {
    	this.controls.updatePlayBet(betQuantity, totalBet);
    }

}