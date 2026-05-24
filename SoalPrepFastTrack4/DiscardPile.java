package SoalPrepFastTrack4;

import java.util.ArrayDeque;
import java.util.Deque;

public class DiscardPile {

    private Deque<Card> cards;

    public DiscardPile() {
        this.cards = new ArrayDeque<>();
    }

    /* Place a card on top of the discard pile */
    public void addCard(Card card) {
        this.cards.push(card); // TODO: switch from add() to push() so the newest card is always on top (Deque head)
    }

    /* Peek at the top card without removing it */
    public Card peekTop() {
        return this.cards.peek();
    }

    public Deque<Card> getThrownCards() {
        return this.cards;
    }

    /* Utility Methods */
    public int size() {
        return this.cards.size();
    }
}