package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import blackjack.Controller;

public class ControlsMenuView extends JPanel {
	
	private Controller controllerObject;
	
	private JButton surrenderBtn;
	private JButton splitBtn;
	private JButton doubleBtn;
	private JButton standBtn;
	private JButton hitBtn;
	
	public ControlsMenuView(Controller controllerObject) {
		this.controllerObject = controllerObject;
		this.setControlsArea();
	}
	
	public void setControlsArea() {
		this.setLayout(new FlowLayout());
		this.setBackground(Color.decode("#181818"));
		this.setBounds(0, 0, 995, 60);
		
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
		
		this.add(this.surrenderBtn);
		this.add(this.splitBtn);
		this.add(this.doubleBtn);
		this.add(this.standBtn);
		this.add(this.hitBtn);
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
