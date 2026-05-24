package SoalPrepFastTrack4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TurnManager — owns the game loop and player rotation.
 *
 * Responsibilities:
 *  - Track whose turn it is (current player index).
 *  - Advance to the next player after each turn.
 *  - Detect when a winner exists and stop the loop.
 *  - Hold a reference to the shared Deck, DiscardPile, and player list.
 *  - Remember any "declared suit" set when an Eight is played, and clear
 *    it once the constraint has been applied for one turn.
 */
public class TurnManager {

    private List<Player> players;
    private Deck deck;
    private DiscardPile discardPile;
    private int currentPlayerIndex;
    private Suits activeDeclaredSuit;
    /**
     * TODO 1 — Constructor
     *   - Accept a List<Player>, a Deck, and a DiscardPile.
     *   - Assign them to fields.
     *   - Set currentPlayerIndex = 0 (first player starts).
     */
    public TurnManager(List<Player> players, Deck deck, DiscardPile discardPile) {
        // TODO 1
        this.players = players;
        this.deck = deck;
        this.discardPile = discardPile;
        this.currentPlayerIndex = 0;
    }

    // -------------------------------------------------------------------------
    // Game setup
    // -------------------------------------------------------------------------

    /**
     * Deal the opening hand to every player and place the first card on the
     * discard pile to kick off the game.
     *
     * TODO 2 — Deal initial cards
     *   - Call GameRules.initialHandSize(players.size()) to get the deal count.
     *   - Loop over each player and call player.drawCard(deck) that many times.
     *
     * TODO 3 — Seed the discard pile
     *   - Draw one card from the deck and add it to the discard pile.
     *   - If the first card is an Eight, keep drawing until a non-Eight appears
     *     (house rule: an Eight cannot be the starting card).
     */
    public void dealInitialCards() {
        // TODO 2: deal cards to each player
        int cardsToBeAssigned = GameRules.initialHandSize(this.players.size());
        this.deck.shuffle();
        for (Player player : this.players) {
            for (int j = 0; j < cardsToBeAssigned; j++) {
                player.getHand().addCard(this.deck.getDeck().removeFirst());
            }
        }
        // TODO 3: seed the discard pile with the first non-Eight card
        Card firstCard = this.deck.getDeck().stream().filter(card -> card.getRank() != Rank.EIGHT).findFirst().orElse(null);
        this.discardPile.addCard(firstCard);
        this.deck.getDeck().remove(firstCard);
    }

    // -------------------------------------------------------------------------
    // Turn advancement
    // -------------------------------------------------------------------------

    /**
     * Advance currentPlayerIndex to the next player (wraps around).
     *
     * TODO 4 — Implement round-robin advancement
     *   - currentPlayerIndex = (currentPlayerIndex + 1) % players.size()
     *
     * Stretch: if you want to support a "reverse" action card later,
     * store a `direction` field (+1 or -1) and multiply before the modulo.
     */
    public void nextTurn() {
        // TODO 4
        this.currentPlayerIndex = (this.currentPlayerIndex + 1) % this.players.size();
    }

    /**
     * Return the player whose turn it currently is.
     *
     * TODO 5 — Return current player
     *   - return players.get(currentPlayerIndex);
     */
    public Player getCurrentPlayer() {
        // TODO 5
        return this.players.get(this.currentPlayerIndex); // placeholder
    }

    // -------------------------------------------------------------------------
    // Main game loop
    // -------------------------------------------------------------------------

    /**
     * Run the full game until a player wins.
     *
     * TODO 6 — Game loop skeleton
     *   a) Print the current state at the start of each turn:
     *        - Current player name
     *        - Top card of the discard pile
     *        - Player's hand (hand.showCards())
     *
     *   b) Invoke getCurrentPlayer().playCard(topCard, discardPile, deck)
     *        - Pass in the current top of the discard pile.
     *
     *   c) After the play, check GameRules.hasWon(currentPlayer).
     *        - If true: print winner announcement and break out of the loop.
     *
     *   d) Call nextTurn() to rotate to the next player.
     *
     * TODO 7 — Deck exhaustion guard
     *   - Before each turn (or inside Player.drawCard), check if deck.isEmpty().
     *   - If empty, reshuffle all but the top card of the discard pile back
     *     into the deck, then continue.
     *   - Tip: add a method reshuffleDeck() here that performs this step.
     *
     * TODO 8 — Declared-suit tracking
     *   - After a player plays an Eight, store the declared suit in a field
     *     (e.g. `private Suits activeDeclaredSuit`).
     *   - Pass it along when calling GameRules.isValidPlay() on the next turn.
     *   - Clear it (set to null) once that constraint has been consumed.
     */
    public void startGame() {
        dealInitialCards();

        System.out.println("\n===== Crazy Eight Game =====");
        this.players.forEach(player -> System.out.println(player.getName()));

        boolean running = true;
        while (running) {
            if (this.deck.isEmpty()) {
                reshuffleDeckFromDiscard();
                System.out.println("Deck reshuffled from discard pile!");
            }

            Player currentPlayer = this.getCurrentPlayer();
            System.out.println("\n--- " + currentPlayer.getName() + "'s turn ---");
            System.out.print("Hand: ");
            currentPlayer.getHand().showCards();
            System.out.println();
            System.out.println("Top card: " + this.discardPile.peekTop());

            try {
                currentPlayer.playCard(this.discardPile.peekTop(), this.discardPile, this.deck, this.activeDeclaredSuit);
            } catch (EmptyDeckException e) {
                System.out.println(e.getMessage());
                reshuffleDeckFromDiscard();
            }

            // Update declared suit tracking
            Card newTop = this.discardPile.peekTop();
            if (newTop.getRank() == Rank.EIGHT) {
                this.activeDeclaredSuit = currentPlayer.getDeclaredSuit();
            } else {
                this.activeDeclaredSuit = null;
            }

            if (GameRules.hasWon(currentPlayer)) {
                running = false;
                System.out.println("Player " + currentPlayer.getName() + " won!");
            } else {
                this.nextTurn();
            }
        }
    }

    // -------------------------------------------------------------------------
    // Helper (stretch goal)
    // -------------------------------------------------------------------------

    /**
     * Reshuffle the discard pile back into the deck when the draw pile runs out.
     *
     * TODO 9 — Reshuffle logic
     *   - Keep the top card of the discard pile in place (it defines the current play).
     *   - Take all other cards from the discard pile, shuffle them, and add
     *     them back to the deck.
     *   - Print a message to inform players that the deck has been reshuffled.
     */
    private void reshuffleDeckFromDiscard() {
        // TODO 9
        Card lastCard =  this.discardPile.peekTop();
        List<Card> reshuffled = new ArrayList<>(this.discardPile.getThrownCards());
        reshuffled.remove(lastCard);

        this.discardPile.getThrownCards().clear();
        this.discardPile.addCard(lastCard);

        Collections.shuffle(reshuffled);
        this.deck.getDeck().addAll(reshuffled);

    }
}