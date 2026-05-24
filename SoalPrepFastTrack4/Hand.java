package SoalPrepFastTrack4;

import java.util.ArrayList;
import java.util.List;
import java.util.Deque;

public class Hand {

    private List<Card> playerCards;

    public Hand() {
        this.playerCards = new ArrayList<>();
    }

    /* Add a card */
    public void addCard(Card card) {
        this.playerCards.add(card);
    }

    /* Remove a card */
    public Card removeCard(int index) {
        return this.playerCards.remove(index);
    }

    public boolean removeCard(Card card) {
        return this.playerCards.remove(card);
    }

    /* Get cards */
    public List<Card> getCards() {
        return this.playerCards;
    }

    /* Utility Methods */
    public int size() {
        return this.playerCards.size();
    }

    public void showCards() {
        this.playerCards.stream().forEach(card -> System.out.print(card + " | "));
    }

    
}
