package bj2;

import bj2.Card.Rank;
import bj2.Card.Suit;

public class Deck {

    private Card[] cards = new Card[52];

    //Default Deck constructor - Only shuffles the cards and creates a deck
    public Deck() 
    {
    	shuffle();
    }

    public final void shuffle() 
    {
    	//Creating a deck of all the cards
        int i = 0;
        for (Suit suit : Suit.values()) 
        {
            for (Rank rank : Rank.values()) 
                cards[i++] = new Card(suit, rank);
        }
    }

    public Card drawCard() 
    {
        Card card = null;
        while (card == null) {
            int index = (int)(Math.random()*cards.length);
            card = cards[index];
            cards[index] = null;
        }
        return card;
    }
//    public Card drawCard() 
//    {
//        Card card = null;
//        card = cards[(int)(Math.random()*cards.length)];
//        return card;
//    }
}