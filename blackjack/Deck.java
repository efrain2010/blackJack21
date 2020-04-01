package blackjack;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	private ArrayList<Card> cards;
	
	public Deck() {
		this.cards = new ArrayList<Card>();
	}
	
	public void addCard(Card card) {
		this.cards.add(card);
	}
	
	public ArrayList<Card> getCards() {
		return this.cards;
	}
	
	public void shuffleCards() {
		Collections.shuffle(this.cards);
	}
	
	public Card drawCard() {
		Card card = cards.get(0);
		cards.remove(0);
		return card;
	}
	
}
