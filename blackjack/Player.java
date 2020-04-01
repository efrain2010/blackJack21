package blackjack;
import java.util.ArrayList;

public abstract class Player {
	
	private String name;
	private int playerNum;
	private ArrayList<Hand> hands;
	private int stakes;
	private boolean won;
	
	public Player(String name, int playerNum) {
		this.name = name;
		this.playerNum = playerNum;
		this.hands = new ArrayList<Hand>();
		this.stakes = 100;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPlayerNum() {
		return playerNum;
	}

	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}

	public ArrayList<Hand> getHands() {
		return hands;
	}

	public void setHands(ArrayList<Hand> hands) {
		this.hands = hands;
	}
	
	public void addHand(Hand hands) {
		this.hands.add(hands);
	}

	public int getStakes() {
		return this.stakes;
	}
	
	public void setStakes(int stakes) {
		this.stakes = stakes;
	}
	
	public void withdrawStakes(int stakes) {
		this.stakes -= stakes;
	}
	
	public void addStakes(int stakes) {
		this.stakes += stakes;
	}
	
	public boolean isDealer() {
		return (this instanceof Dealer); 
	}
	
}
