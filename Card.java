
public class Card {
	private int rank;
	private String suit;
	
	// Constructor
	public Card (int rank, String suit) {
		
		this.rank = rank;
		this.suit = suit;
		
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
	
	// Override toString
	public String toString() {
		return Integer.toString(this.rank) + " of " + this.suit;
	}

}
