import java.util.ArrayList;

public class Board {

	private Deck deck;
	private ArrayList<Player> players;
	private Player dealer;
	
	public Board(Deck deck) {
		this.deck = deck;
		this.players = new ArrayList<Player>();
	}
	
	public void initGame(int numOfPlayers) {
		this.deck.shuffleCards();
		this.dealCards(numOfPlayers);
	}

	public Deck getDeck() {
		return this.deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	
	public Player getDealer() {
		return this.dealer;
	}

	public void setDealer(Player dealer) {
		this.dealer = dealer;
	}

	public ArrayList<Player> getPlayers() {
		return this.players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	private void dealCards(int numOfPlayers) {
		
		Hand tempHand = null;
		
		for(int i = 0; i < numOfPlayers; i++) {
			Player tempPlayer = new Human("Player " + (i + 1), i + 1);
			
			tempHand = new Hand();
			tempHand.addCard(this.deck.drawCard());
			tempHand.addCard(this.deck.drawCard());
			
			tempPlayer.addHand(tempHand);
			
			this.players.add(tempPlayer);
		}
		
		this.dealer = new Dealer("Dealer ", 0);
		tempHand = new Hand();
		tempHand.addCard(this.deck.drawCard());
		tempHand.addCard(this.deck.drawCard());
		this.dealer.addHand(tempHand);
		
	}
	
}
