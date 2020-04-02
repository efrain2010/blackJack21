import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BetView extends JPanel {
	
	private Controller controllerObject;
	
	private JLabel totalBetLbl, playerStakesLbl;
	private JButton setDealBtn, stake1, stake5, stake25, stake50, stake100, stake500, stake1000, removeBetBtn;
	private JPanel betsArea;
	
	public BetView(Controller controllerObject) {
		this.controllerObject = controllerObject;
		setLayout();
	}
	
	private void setLayout() {
		this.setOpaque(false);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setSize(250, 250);
		
		this.betsArea = new JPanel();
		this.betsArea.setLayout(new BorderLayout());
		this.betsArea.setOpaque(false);
		
		this.removeBetBtn = new JButton();
		this.removeBetBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.removeBetBtn.setOpaque(false);
		this.removeBetBtn.setContentAreaFilled(false);
		this.removeBetBtn.setBorderPainted(false);
		this.removeBetBtn.addActionListener(this.controllerObject);
		this.betsArea.add(this.removeBetBtn);
		
		JPanel dealbtnsPanel = new JPanel();
		dealbtnsPanel.setLayout(new BoxLayout(dealbtnsPanel, BoxLayout.Y_AXIS));
		dealbtnsPanel.setOpaque(false);
		
		
		JLabel titleLabel = new JLabel("Set a Bet");
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font("Courrier New", Font.BOLD, 16));
		
		this.playerStakesLbl = new JLabel("Player Stakes: " + this.controllerObject.getPlayer().getStakes());
		this.playerStakesLbl.setForeground(Color.WHITE);
		this.playerStakesLbl.setFont(new Font("Courrier New", Font.CENTER_BASELINE, 16));
		
		this.totalBetLbl = new JLabel("Total Bet: 0");
		this.totalBetLbl.setForeground(Color.WHITE);
		this.totalBetLbl.setFont(new Font("Courrier New", Font.CENTER_BASELINE, 16));
		
		this.setDealBtn = new JButton("Deal");
		this.setDealBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setDealBtn.addActionListener(this.controllerObject);

		dealbtnsPanel.add(titleLabel);
		dealbtnsPanel.add(this.playerStakesLbl);
		dealbtnsPanel.add(this.totalBetLbl);
		dealbtnsPanel.add(this.setDealBtn);
		
		JPanel stakebtnsPanel = new JPanel();
		stakebtnsPanel.setLayout(new GridLayout(2, 4, 5, 5));
		stakebtnsPanel.setOpaque(false);
		
		this.stake1 = createStakeButton("./images/1.png");
		this.stake5 = createStakeButton("./images/5.png");
		this.stake25 = createStakeButton("./images/25.png");
		this.stake50 = createStakeButton("./images/50.png");
		this.stake100 = createStakeButton("./images/100.png");
		this.stake500 = createStakeButton("./images/500.png");
		this.stake1000 = createStakeButton("./images/1000.png");
		
		stakebtnsPanel.add(this.stake1);
		stakebtnsPanel.add(this.stake5);
		stakebtnsPanel.add(this.stake25);
		stakebtnsPanel.add(this.stake50);
		stakebtnsPanel.add(this.stake100);
		stakebtnsPanel.add(this.stake500);
		stakebtnsPanel.add(this.stake1000);
		
		this.add(this.betsArea);
		this.add(dealbtnsPanel);
		this.add(stakebtnsPanel);
		
	}
	
	public JButton createStakeButton(String imagePath) {
		
		ImageIcon background = new ImageIcon(imagePath);
		Image img = background.getImage();
		Image temp = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		background = new ImageIcon(temp);
		
		JButton btn = new JButton(background);
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn.addActionListener(this.controllerObject);
		btn.setOpaque(false);
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		
		return btn;
	}
	
	public void addBet(int betQuantity, int totalBet) {
		ImageIcon background = new ImageIcon("./images/" + betQuantity + ".png");
		Image img = background.getImage();
		Image temp = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		background = new ImageIcon(temp);
		
		this.removeBetBtn.setIcon(background);
		this.playerStakesLbl.setText("Player Stakes: " + this.controllerObject.getPlayer().getStakes());
		this.totalBetLbl.setText("Total Bet: " + totalBet);
	}
	
	public void removeBet(int lastBet, int playerStakes, int playerActualBet) {
		System.out.println(lastBet);
		System.out.println(playerStakes);
		System.out.println(playerActualBet);
		
		this.playerStakesLbl.setText("Player Stakes: " + playerStakes);
		this.totalBetLbl.setText("Total Bet: " + playerActualBet);
		
		String imagePath = "./images/" + lastBet + ".png";
		if(lastBet <= 0) {
			imagePath = "";
		}
		
		ImageIcon background = new ImageIcon(imagePath);
		Image img = background.getImage();
		Image temp = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		background = new ImageIcon(temp);
		
		this.removeBetBtn.setIcon(background);
	}
	
	public JPanel getBetsArea() {
		return this.betsArea;
	}
	
	public JButton getStake1() {
		return this.stake1;
	}

	public JButton getStake5() {
		return this.stake5;
	}

	public JButton getStake25() {
		return this.stake25;
	}

	public JButton getStake50() {
		return this.stake50;
	}

	public JButton getStake100() {
		return this.stake100;
	}
	
	public JButton getStake500() {
		return this.stake500;
	}

	public JButton getStake1000() {
		return this.stake1000;
	}

	public JButton getSetDealBtn() {
		return this.setDealBtn;
	}
	
	public JButton getRemoveBetBtn() {
		return this.removeBetBtn;
	}
	
	public JLabel getTotalBetLbl() {
		return this.totalBetLbl;
	}

}
