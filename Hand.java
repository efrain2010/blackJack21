import java.util.ArrayList;

public class Hand {
	
	private ArrayList<Card> cards;

	public Hand() {
		this.cards = new ArrayList<Card>();
	}
	
	public void addCard(Card card) {
		this.cards.add(card);
	}
	
	public ArrayList<Card> getCards() {
		return this.cards;
	}
	
}
