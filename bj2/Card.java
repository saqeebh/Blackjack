package bj2;

import javafx.scene.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Card extends Parent {

    enum Suit { HEARTS, DIAMONDS, CLUBS, SPADES };

    enum Rank 
    {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), 
        NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10), ACE(11);

        final int value;
        private Rank(int value) 
        {
        	this.value = value;
        }
    };

    public final Suit suit;
    public final Rank rank;
    public final int value;

    public Card(Suit suit, Rank rank) 
    {
        this.suit = suit;
        this.rank = rank;
        this.value = rank.value;

        Rectangle card = new Rectangle(80, 100);
        card.setFill(Color.LIGHTGRAY);

        Text text = new Text(this.toString());

        getChildren().add(new StackPane(card, text));
    }

    //This is what will appear over the cards in the GUI
    @Override
    public String toString() 
    {
        return rank.toString() + "\n of \n" + suit.toString();
    }
}