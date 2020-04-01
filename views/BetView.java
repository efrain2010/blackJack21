package views;

import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import blackjack.Controller;

public class BetView extends JPanel {
	
	private Controller controllerObject;
	
	private JButton setDealBtn;
	
	public BetView(Controller controllerObject) {
		this.controllerObject = controllerObject;
		setLayout();
	}
	
	private void setLayout() {
		this.setOpaque(false);
		this.setSize(250, 250);
		
		JLabel label = new JLabel("Set a Bet");
		this.setDealBtn = new JButton("Deal");
		this.setDealBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JButton stake1 = new JButton();
		JButton stake5 = new JButton();
		JButton stake25 = new JButton();
		JButton stake50 = new JButton();
		JButton stake100 = new JButton();
		JButton stake500 = new JButton();
		JButton stake1000 = new JButton();
		
		stake1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		stake5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		stake25.setCursor(new Cursor(Cursor.HAND_CURSOR));
		stake50.setCursor(new Cursor(Cursor.HAND_CURSOR));
		stake100.setCursor(new Cursor(Cursor.HAND_CURSOR));
		stake500.setCursor(new Cursor(Cursor.HAND_CURSOR));
		stake1000.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		this.setDealBtn.addActionListener(this.controllerObject);
		
		this.add(label);
		this.add(this.setDealBtn);
	}
	
	public JButton getSetDealBtn() {
		return this.setDealBtn;
	}

}
