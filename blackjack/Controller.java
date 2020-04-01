package blackjack;

import views.BoardView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
	
	private Board boardObject;
	private Model modelObject;
	
	private BoardView boardViewObject;
	
	public Controller(Model modelObject) {
		this.modelObject = modelObject;
		this.boardObject = new Board(this.modelObject.getDeck(), 2);
		
		this.boardViewObject = new BoardView(this);
		this.boardViewObject.setVisible(true);
	}
	
	public Model getModel() {
		return this.modelObject;
	}
	
	public Board getBoard() {
		return this.boardObject;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.boardViewObject.getBetView().getSetDealBtn()) {
			this.boardViewObject.dealCards();
        } else if (e.getSource() == this.boardViewObject.getControls().getHitBtn()) {
            this.hitBtnAction(0);
        } else if (e.getSource() == this.boardViewObject.getControls().getSurrenderBtn()) {
            System.out.println("Click on the Surrender Button");
        } else if (e.getSource() == this.boardViewObject.getControls().getSplitBtn()) {
            System.out.println("Click on the Split Button");
        } else if (e.getSource() == this.boardViewObject.getControls().getDoubleBtn()) {
            System.out.println("Click on the Double Button");
        } else if (e.getSource() == this.boardViewObject.getControls().getStandBtn()) {
            System.out.println("Click on the Stand Button");
        }
    }
	
	private void hitBtnAction(int numPlayer) {
		Player player = this.boardObject.getPlayers().get(numPlayer);
		if(player.getHands().get(0).getCardsPoints(player, false) < 21) {
			Card newCard = this.modelObject.getDeck().drawCard();
			player.getHands().get(0).addCard(newCard);
			this.boardViewObject.giveCard(numPlayer, newCard);
		}
	}
	
}
