import java.util.ArrayList;

public class Board {

	private Deck deck;
	private Model objectModel;
	private int numberOfPlayers = 2;
	private ArrayList<Player> players;
	private Player dealer;
	
	public Board(Model objectModel) {
		this.objectModel = objectModel;
		this.deck = this.objectModel.getDeck();
		this.players = new ArrayList<Player>();
		
		this.deck.shuffleCards();
		this.dealCards();
		
		BoardView viewObject = new BoardView(objectModel);
		viewObject.setBoard(dealer, players);
		viewObject.setVisible(true);
		
		int dealerStatus = checkIfWin(this.dealer.getHands().get(0), true);
		System.out.println(dealerStatus);
		
		for(Player player : this.players) {			
			int playStatus = checkIfWin(player.getHands().get(0), true);
			System.out.println(playStatus);
		}
		
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	
	private void dealCards() {
		
		this.dealer = new Player("Dealer ", 0);
		Hand tempHand = new Hand();
		tempHand.addCard(this.deck.drawCard());
		tempHand.addCard(this.deck.drawCard());
		this.dealer.addHand(tempHand);
		
		for(int i = 0; i < numberOfPlayers; i++) {
			Player tempPlayer = new Player("Player " + (i + 1), i + 1);
			
			tempHand = new Hand();
			tempHand.addCard(this.deck.drawCard());
			tempHand.addCard(this.deck.drawCard());
			
			tempPlayer.addHand(tempHand);
			
			this.players.add(tempPlayer);
		}
	}
	
	private int checkIfWin(Hand hand, boolean firstPlay) {
		int sum = 0;
		int playerWon = 0;
		
		if(firstPlay) {
			Card card1 = hand.getCards().get(0);
			Card card2 = hand.getCards().get(1);
			if(card1.getValue() == 1 && card2.getValue() == 10) {
				playerWon = 1;
			}
		}
		
		for(int i = 0; i < hand.getCards().size(); i++) {
			sum += hand.getCards().get(i).getValue();
		}
		
		if(sum > 21) {
			playerWon = -1;
		} else if(sum == 21) {
			playerWon = 1;
		}
		
		return playerWon;
		
	}
	
}
