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

    public static void main(String[] args) {
        
        Deck deck = new Deck();
        Hand hand = new Hand();
        deck.shuffle();

        Deque<Card> decks = deck.getDeck();
        for (int i = 0; i < 13; i++) {
            hand.addCard(decks.pop());
        }

        hand.getCards().stream().forEach(card -> System.out.println(card));
        hand.removeCard(4);
        hand.removeCard(5);
        hand.showCards();
    }
    
}
