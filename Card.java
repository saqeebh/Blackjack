
public class Card {
	private int rank;
	private int value;
	private String suit;
	
	// Constructor
	public Card (int rank, String suit) {
		
		this.rank = rank;
		this.suit = suit;
		if (rank <= 10) this.value = rank;
		else if (rank > 10 && rank < 14) this.value = 10;
		else if (rank == 14) this.value = 11;
		
	}
	
	// Rank getter
	public int getRank() {
		return this.rank;
	}
	
	// Rank setter
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	// Suit getter
	public String getSuit() {
		return this.suit;
	}
	
	// Suit setter
	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	// Value getter
	public int getValue() {
		return this.value;
	}
	
	// Value setter
	public void setValue(int value) {
		this.value = value;
	}
	
	// Override toString
	public String toString() {
		return Integer.toString(this.rank) + " of " + this.suit + "(" + this.value + ")";
	}

}
