
import java.io.Serializable;
import java.util.ArrayList;

public class Hand implements Serializable {
	
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
	
	public int getCardsPoints(Player player, boolean firstHand) {
		int sum = 0;
		
		for(Card card : this.cards) {
			sum = sum + card.getValue();
		}
		
		if(firstHand) {
			if(player.isDealer()) {
				sum = this.cards.get(this.cards.size()-1).getValue();
			} else { 
				if(this.cards.get(0).getValue() == 1 && this.cards.get(1).getValue() == 10) {
					sum = 21;
				}
			}
		}
		
		return sum;
	}
	
}
