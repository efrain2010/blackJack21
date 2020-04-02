
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Controller implements ActionListener {
	
	private Board boardObject;
	private Model modelObject;
	private ObjectOutputStream outputStream;
	
	private BoardView boardViewObject;
	private Player player;
	
	public Controller(Model modelObject, ObjectOutputStream outputStream) {
		this.modelObject = modelObject;
		this.outputStream = outputStream;
		
		this.boardObject = new Board(this.modelObject.getDeck());
		addPlayer(BoardView.initWindow());

		this.boardViewObject = new BoardView(this);
		this.boardViewObject.setBoard();
		this.boardViewObject.setVisible(true);
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public Model getModel() {
		return this.modelObject;
	}
	
	public Board getBoard() {
		return this.boardObject;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.boardViewObject.getBetView().getSetDealBtn()) {
			checkBet();
        } else if (e.getSource() == this.boardViewObject.getBetView().getStake1()) {
            System.out.println("Bet 1");
            hitStakeBtn(1);
        } else if (e.getSource() == this.boardViewObject.getBetView().getStake5()) {
            System.out.println("Bet 5");
            hitStakeBtn(5);
        } else if (e.getSource() == this.boardViewObject.getBetView().getStake25()) {
            System.out.println("Bet 25");
            hitStakeBtn(25);
        } else if (e.getSource() == this.boardViewObject.getBetView().getStake50()) {
            System.out.println("Bet 50");
            hitStakeBtn(50);
        } else if (e.getSource() == this.boardViewObject.getBetView().getStake100()) {
            System.out.println("Bet 100");
            hitStakeBtn(100);
        } else if (e.getSource() == this.boardViewObject.getBetView().getStake500()) {
            System.out.println("Bet 500");
            hitStakeBtn(500);
        } else if (e.getSource() == this.boardViewObject.getBetView().getStake1000()) {
            System.out.println("Bet 1000");
            hitStakeBtn(1000);
        } else if (e.getSource() == this.boardViewObject.getBetView().getRemoveBetBtn()) {
            System.out.println("Remove Bet");
            gitRemoveStakeBtn();
        }else if (e.getSource() == this.boardViewObject.getControls().getHitBtn()) {
            this.hitBtnAction(0);
        } else if (e.getSource() == this.boardViewObject.getControls().getSurrenderBtn()) {
            System.out.println("Click on the Surrender Button");
        } else if (e.getSource() == this.boardViewObject.getControls().getSplitBtn()) {
            System.out.println("Click on the Split Button");
        } else if (e.getSource() == this.boardViewObject.getControls().getDoubleBtn()) {
            System.out.println("Click on the Double Button");
            doublePlayerBet();
        } else if (e.getSource() == this.boardViewObject.getControls().getStandBtn()) {
            System.out.println("Click on the Stand Button");
        }
    }
	
	private void checkBet() {
		if(this.player.getActualBet() > 0) {		
			this.boardViewObject.dealCards();
		}
	}
	
	private void hitBtnAction(int numPlayer) {
		if(this.player.getHands().get(0).getCardsPoints(this.player, false) < 21) {
			Card newCard = this.modelObject.getDeck().drawCard();
			this.player.getHands().get(0).addCard(newCard);
			this.boardViewObject.giveCard(numPlayer, newCard);
		}
	}
	
	private void hitStakeBtn(int betQuantity) {
		try {
			if(betQuantity <= this.player.getStakes()) {
				this.player.withdrawStakes(betQuantity);
				this.player.addBetToPlay(betQuantity);
				this.boardViewObject.addPlayerBet(betQuantity, this.player.getActualBet());
				
				this.outputStream.writeObject(this.boardObject);
			}
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	private void gitRemoveStakeBtn() {
		if(this.player.getBetStakes().size() > 0) {
			int lastBet = this.player.removeLastBet();
			int actualStakes = this.player.getStakes();
			int playerActualBet = this.player.getActualBet();
			this.boardViewObject.removePlayerBet(lastBet, actualStakes, playerActualBet);
		}
	}
	
	private void doublePlayerBet() {
		int playerStakes = this.player.getStakes();
		int playerActualbet = this.player.getActualBet();
		if(playerActualbet*2 <= playerStakes) {
			this.player.withdrawStakes(playerActualbet);
			this.player.addBetToPlay(playerActualbet);
			this.boardViewObject.updatePlayBet(playerActualbet, this.player.getActualBet());
		}
	}

	public void addPlayer(String playerName) {
		try {
			this.player = new Human(playerName, 1);
			this.boardObject.addPlayer(player);
			this.outputStream.writeObject(this.boardObject);
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
}
