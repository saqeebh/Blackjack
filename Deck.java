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
		if (deck.size() > 0) {
			for (int i = 0; i < deck.size(); i++){
				output = output + Integer.toString(deck.get(i).getRank()) + " of " + 
						deck.get(i).getSuit() + "(" + deck.get(i).getValue() + ")\n";
			}
		} else return "Deck is empty";
		
		return output;
		
	}
	
	// Returns size of deck for testing purposes
	public int sizeOf() {
		return deck.size();
	}
	
	// Return a random Card object from the deck, removing that card from the deck
	public Card dealCard() {
		Random random = new Random();
		if (this.sizeOf() > 1) {
			int cardNum = random.nextInt(this.sizeOf());
			Card cardDealt = this.deck.get(cardNum);
			this.deck.remove(cardNum);
			return cardDealt;
		} else {
			Card cardDealt = this.deck.get(0);
			this.deck.remove(0);
			return cardDealt;
		}
		
	}
	
}
