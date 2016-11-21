
public class TestClass {

	public static void main(String[] args) {
		
		// Test Card
		Card card = new Card(5, "Spades");
		System.out.println(card.toString());
		
		// Test Deck
		Deck deck = new Deck();
		System.out.println(deck.toString());
		System.out.println(deck.sizeOf());
		
		System.out.println(deck.dealCard());
		System.out.println(deck.dealCard());
		System.out.println(deck.dealCard());
		
		System.out.println(deck.toString());

	}

}
