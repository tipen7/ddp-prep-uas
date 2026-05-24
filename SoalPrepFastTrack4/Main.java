package SoalPrepFastTrack4;

import java.util.ArrayList;
import java.util.List;

/**
 * Main — entry point to run a Crazy Eights game.
 *
 * Wire up all the components here and hand control to TurnManager.
 * No game logic lives here; this class only bootstraps the objects.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("=== Crazy Eights ===\n");

        // 1. Create the shared deck and shuffle it
        Deck deck = new Deck();
        deck.shuffle();

        // 2. Create the shared discard pile
        DiscardPile discardPile = new DiscardPile();

        // 3. Create players
        List<Player> players = new ArrayList<>();
        players.add(new Player("Alice"));
        players.add(new Player("Bob"));
        // Uncomment the line below to play with 3 players (deal size changes to 5)
        // players.add(new Player("Charlie"));

        // 4. Hand everything to TurnManager and start the game
        TurnManager turnManager = new TurnManager(players, deck, discardPile);
        turnManager.startGame();
    }
}