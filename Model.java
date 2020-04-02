
public class Model {
	
	private Deck deck;
	final private String[] suits = {"Clober", "Diamond", "Heart", "Spade"};
	final private int cardPerSuit = 13;
	
	public Model() {
		this.deck = new Deck();
		
		for(String suit : suits) {
			for(int i = 0; i < this.cardPerSuit; i++) {
				int value = i+1;
				if(i > 8) {
					value = 10;
				}
				
				String image = "";
				if(suit.equals("Clober")) {
					image = "t"+(i+1)+".png";
				} else if(suit.equals("Diamond")) {
					image = "d"+(i+1)+".png";
				} else if(suit.equals("Heart")) {
					image = "h"+(i+1)+".png";
				} else if(suit.equals("Spade")) {
					image = "a"+(i+1)+".png";
				}
				
				this.deck.addCard(new Card(value, suit, image));
			}
		}
		
	}
	
	public Deck getDeck() {
		return this.deck;
	}
	
}
