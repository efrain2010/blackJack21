import javax.swing.JButton;

public class PlayerHand {

	private JButton hitBtn;
	private JButton standBtn;
	
	public PlayerHand() {
		
		this.hitBtn = new JButton("HIT");
		this.standBtn = new JButton("STAND");
		
	}
	
	public JButton getHitBtn() {
		return this.hitBtn;
	}
	
	public void setHitBtn(JButton hitBtn) {
		this.hitBtn = hitBtn;
	}

	public JButton getStandBtn() {
		return this.standBtn;
	}
	
	public void setNameLabel(JButton standBtn) {
		this.standBtn = standBtn;
	}
	
}
