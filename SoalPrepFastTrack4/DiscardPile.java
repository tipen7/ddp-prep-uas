package SoalPrepFastTrack4;

import java.util.ArrayDeque;
import java.util.Deque;

public class DiscardPile {

    private Deque<Card> cards;

    public DiscardPile() {
        this.cards = new ArrayDeque<>();
    }

    /* Add a card */
    public void addCard(Card card) {
        this.cards.add(card);
    }

    /* Peek a card */
    public Card peekTop() {
        return this.cards.peek();
    }

    /* Utility Methods */
    public int size() {
        return this.cards.size();
    }
    
}
