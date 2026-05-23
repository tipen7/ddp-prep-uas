package SoalPrepFastTrack4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Player {

    private Hand hand;
    private String name;
    
    public Player(String name) {
        this.hand = new Hand();
        this.name = name;
    }

    
    public void drawCard(Deck deck) {

        try {

            Card drawedCard = deck.draw();
            this.hand.addCard(drawedCard);

        } catch (EmptyDeckException e) {
            System.out.println(e.getMessage());
        }
    }

    public void playCard(Card prev) {

        
    }

    public Hand getHand() {
        return this.hand;
    }

    public String getName() {
        return this.name;
    }
    
}
