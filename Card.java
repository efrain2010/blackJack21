
public class Card {

	private int value;
	private String type;
	private String image;
	
	public Card(int value, String type, String image) {
		this.type = type;
		this.value = value;
		this.image = image;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public String toString() {
		return "figure: " + this.type + "\nvalue:" + this.value + "\n";
	}
	
}
