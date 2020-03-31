import java.util.ArrayList;

public class Player {
	
	private String name;
	private int playerNum;
	private ArrayList<Hand> hands;
	private boolean won;
	
	public Player(String name, int playerNum) {
		this.name = name;
		this.playerNum = playerNum;
		this.hands = new ArrayList<Hand>(); 
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
	
}
