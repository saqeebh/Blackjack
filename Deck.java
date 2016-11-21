import java.util.*;

public class Deck {
	ArrayList<Card> deck = new ArrayList<Card>();

	// Deck consists of 4 suits, each with 13 ranks
	public Deck() {
		
		// Hearts
		for (int i = 2; i <= 14; i++) {
			this.deck.add(new Card(i, "Hearts"));
		}
		
		// Diamonds
		for (int i = 2; i <= 14; i++) {
			this.deck.add(new Card(i, "Diamonds"));
		}
		
		// Spades
		for (int i = 2; i <= 14; i++) {
			this.deck.add(new Card(i, "Spades"));
		}
		
		// Clubs
		for (int i = 2; i <= 14; i++) {
			this.deck.add(new Card(i, "Clubs"));
		}
		
	}
	
	public String toString() {
		
		String output = "";
		for (int i = 0; i < deck.size(); i++){
			output = output + Integer.toString(deck.get(i).getRank()) + " of " + 
					deck.get(i).getSuit() + "\n";
		}
		
		return output;
		
	}
	
	// Returns size of deck for testing purposes
	public int sizeOf() {
		return deck.size();
	}
	
}
