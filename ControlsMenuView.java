
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ControlsMenuView extends JPanel {
	
	private Controller controllerObject;
	
	private JButton surrenderBtn, splitBtn, doubleBtn, standBtn, hitBtn;
	private JLabel controlsPlayerStakes, controlsPlayerBet;
	
	public ControlsMenuView(Controller controllerObject) {
		this.controllerObject = controllerObject;
		this.setControlsArea();
	}
	
	public void setControlsArea() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(Color.decode("#181818"));
		this.setBounds(0, 0, 650, 150);
		
		JPanel topPanel = new JPanel(new FlowLayout());
		topPanel.setOpaque(false);
		
		System.out.println(this.controllerObject.getPlayer());
		this.controlsPlayerStakes = new JLabel("Player Stakes: " + this.controllerObject.getPlayer().getStakes());
		this.controlsPlayerStakes.setForeground(Color.WHITE);
		this.controlsPlayerBet = new JLabel("Total Bet: " + this.controllerObject.getPlayer().getActualBet());
		this.controlsPlayerBet.setForeground(Color.WHITE);
		
		topPanel.add(this.controlsPlayerStakes);
		topPanel.add(this.controlsPlayerBet);
		
		JPanel bottomPanel = new JPanel(new FlowLayout());
		bottomPanel.setOpaque(false);
		
		this.surrenderBtn = new JButton("Surrender");
		this.splitBtn = new JButton("Split");
		this.doubleBtn = new JButton("Double");
		this.standBtn = new JButton("Stand");
		this.hitBtn = new JButton("Hit");
		

		this.surrenderBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.splitBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.doubleBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.standBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.hitBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		this.surrenderBtn.addActionListener(this.controllerObject);
		this.splitBtn.addActionListener(this.controllerObject);
		this.doubleBtn.addActionListener(this.controllerObject);
		this.standBtn.addActionListener(this.controllerObject);
		this.hitBtn.addActionListener(this.controllerObject);
		
		bottomPanel.add(this.surrenderBtn);
		bottomPanel.add(this.splitBtn);
		bottomPanel.add(this.doubleBtn);
		bottomPanel.add(this.standBtn);
		bottomPanel.add(this.hitBtn);
		
		this.add(topPanel);
		this.add(bottomPanel);
	}
	
	public void updatePlayBet(int betQuantity, int totalBet) {
		this.controlsPlayerStakes.setText("Player Stakes: " + this.controllerObject.getPlayer().getStakes());
		this.controlsPlayerBet.setText("Total Bet: " + totalBet);
	}

	public JButton getSurrenderBtn() {
		return surrenderBtn;
	}

	public void setSurrenderBtn(JButton surrenderBtn) {
		this.surrenderBtn = surrenderBtn;
	}

	public JButton getSplitBtn() {
		return splitBtn;
	}

	public void setSplitBtn(JButton splitBtn) {
		this.splitBtn = splitBtn;
	}

	public JButton getDoubleBtn() {
		return doubleBtn;
	}

	public void setDoubleBtn(JButton doubleBtn) {
		this.doubleBtn = doubleBtn;
	}

	public JButton getStandBtn() {
		return standBtn;
	}

	public void setStandBtn(JButton standBtn) {
		this.standBtn = standBtn;
	}

	public JButton getHitBtn() {
		return hitBtn;
	}

	public void setHitBtn(JButton hitBtn) {
		this.hitBtn = hitBtn;
	}

}
