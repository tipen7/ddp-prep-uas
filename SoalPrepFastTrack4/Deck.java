package SoalPrepFastTrack4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;


public class Deck {

    private Deque<Card> cards;
    
    public Deck() {

        /* ===============================================================================
            The moment deck get instantiated, there are automatically filled with 52 cards 
           =============================================================================== */

        this.cards = new ArrayDeque<>();

        for (Suits suit: Suits.values()) {
            for (Rank rank: Rank.values()) {
                this.cards.add(new Card(suit, rank));
            }
        }
    }

    /* Method to shuffle cards */

    public void shuffle() {
        List<Card> temp = new ArrayList<>(this.cards);
        Collections.shuffle(temp);
        this.cards.clear();
        this.cards.addAll(temp);
    }

    /* Method to draw card (from the top) */
    public Card draw() throws EmptyDeckException {

        if (this.cards.isEmpty()) {
            throw new EmptyDeckException("The deck has 0 cards");
        }

        return this.cards.removeLast();
    }
    
    /* Utility Methods */
    public Deque<Card> getDeck() {
        return this.cards;
    }

    public int getDeckSize() {
        return this.cards.size();
    }

    public boolean isEmpty() {
        return this.cards.isEmpty();
    }

    public static void main(String[] args) {
        
        Deck deck = new Deck();
        deck.shuffle();
        System.out.println("Deck size: " + deck.getDeckSize());
        System.out.println("Deck is empty? " + (deck.isEmpty() ? "Yes" : "No"));
        
        try {
            Card draw =  deck.draw();
            System.out.println("Drawing cards from the deck: " + draw);
        } catch (EmptyDeckException e) {
            System.out.println(e.getMessage());
        }
    
    }
}
