
import java.util.ArrayList;

public abstract class Player {
	
	private String name;
	private int playerNum;
	private ArrayList<Hand> hands;
	private int stakes;
	private boolean won;
	private int actualBet;
	private ArrayList<Integer> betStakes;
	
	public Player(String name, int playerNum) {
		this.name = name;
		this.playerNum = playerNum;
		this.hands = new ArrayList<Hand>();
		this.betStakes = new ArrayList<Integer>();
		this.stakes = 3000;
		this.actualBet = 0;
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

	public int getActualBet() {
		return this.actualBet;
	}
	
	public void setActualBet(int actualBet) {
		this.actualBet = actualBet;
	}
	
	public ArrayList<Integer> getBetStakes() {
		return this.betStakes;
	}
	
	public void setBetStakes(ArrayList<Integer> betStakes) {
		this.betStakes = betStakes;
	}
	
	public int getStakes() {
		return this.stakes;
	}
	
	public void setStakes(int stakes) {
		this.stakes = stakes;
	}
	
	public void addBetToPlay(int bet) {
		this.betStakes.add(bet);
		this.actualBet = this.actualBet + bet;
	}
	
	public int removeLastBet() {
		int bet = this.betStakes.get(this.betStakes.size()-1);
		this.actualBet = this.actualBet - bet;
		this.stakes = this.stakes + bet;
		this.betStakes.remove(this.betStakes.size()-1);
		
		int lastBest = 0;
		if(this.betStakes.size() > 0) {
			lastBest = this.betStakes.get(this.betStakes.size()-1);			
		}
		return lastBest;
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
