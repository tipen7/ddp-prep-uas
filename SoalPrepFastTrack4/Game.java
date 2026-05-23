package SoalPrepFastTrack4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Game {

    private Deck deck;
    private List<Player> player;
    private LinkedList<Card> table;

    public Game(List<Player> players) {
        this.player = players;
        this.deck = new Deck();
        this.table = new LinkedList<>();
    }

    // public void assignCards() {

    //     List<Card> cards = this.deck.shuffle();
    //     int playersCount = this.player.size();

    //     int START = 0;
    //     for (int i = 0; i < playersCount; i++) {
    //         for (int j = START; j < 13 * (i + 1); j++) {
    //             this.player.get(i).addCard(cards.get(j));
    //         }
    //         START = 13 * (i + 1);
            
    //     }

    //     for (Player player: this.player) {
    //         player.showCards();
    //         System.out.println("Size: " + player.getCardsSize());
    //     }
        
    // }



    // public static void main(String[] args) {

    //     Player p1 = new Player( "Idris");
    //     Player p2 = new Player( "Daffa");
    //     Player p3 = new Player( "Gozali");
    //     Player p4 = new Player( "Apipuy");
        
    //     Game game = new Game(Arrays.asList(p1, p2, p3, p4));

    //     game.assignCards();
    // }
    
}
