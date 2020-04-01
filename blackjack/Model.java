package blackjack;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class Model {
	
	private Deck deck;
	final private int[] stakes = {1, 5, 25, 50, 100, 500, 1000};
	
	public Model() {
		this.deck = new Deck();
		try {
			FileHandler file = new FileHandler("./deck-file.json");
			JSONArray object = null;
			
			try {
				object = file.readJSONFile();
			} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			for(int i = 0; i < object.size(); i++) {
				JSONObject row = (JSONObject) object.get(i);
				this.deck.addCard(new Card((int)(long) row.get("value"), (String) row.get("type"), (String) row.get("image")));
			}
					
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred while opening the file");
			e.printStackTrace();
		}
		
	}
	
	public Deck getDeck() {
		return this.deck;
	}
	
	public int[] getStakes() {
		return this.stakes;
	}

}
