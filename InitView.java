
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InitView extends JFrame {
	
	public InitView() {
		
		this.setSize(800,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String name = JOptionPane.showInputDialog(this, "What's your name?");
		
	}

}
