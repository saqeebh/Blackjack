package bj2;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;

import bj2.Card.Rank;


public class Hand {

    private ObservableList<Node> cards;
    private SimpleIntegerProperty value = new SimpleIntegerProperty(0);

    private int aces = 0;

    public Hand(ObservableList<Node> cards) {
        this.cards = cards;
    }

    public void hitMe(Card card) 
    {
        cards.add(card);

        if (card.rank == Rank.ACE)
            aces++;

        if (value.get() + card.value > 21 && aces > 0) 
        {
            value.set(value.get() + card.value - 10);    //then ace=1, !=11
            aces--;
        }
        else
            value.set(value.get() + card.value);
    }

    public void resetScore() {
        cards.clear();
        value.set(0);
        aces = 0;
    }

    //gets the integer value of the enum card type
    public SimpleIntegerProperty valueProperty() {
        return value;
    }
}