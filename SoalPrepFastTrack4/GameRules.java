package SoalPrepFastTrack4;

/**
 * GameRules — stateless utility class that encodes all Crazy Eights rule logic.
 *
 * Keep every method static; this class owns NO mutable state.
 * TurnManager and Player delegate all rule questions here.
 */
public class GameRules {

    // -------------------------------------------------------------------------
    // Core play validation
    // -------------------------------------------------------------------------

    /**
     * Decide whether a card may legally be played on top of the current discard.
     *
     * TODO 1 — Eight is always wild
     *   - If cardToPlay.getRank() == Rank.EIGHT, return true unconditionally.
     *
     * TODO 2 — Suit override after an Eight was played
     *   - Add an overloaded version (or an extra parameter) that accepts a
     *     `Suits declaredSuit`.
     *   - When declaredSuit is not null, the card must match that suit instead
     *     of the suit on topCard.
     *
     * TODO 3 — Normal matching rules
     *   - A card is valid if it matches the top card's suit OR rank.
     *   - e.g. 7♠ can be played on any ♠, or on any other 7.
     *
     * @param cardToPlay the card the player wants to play
     * @param topCard    the current top card of the discard pile
     * @return true if the move is legal
     */
    public static boolean isValidPlay(Card cardToPlay, Card topCard) {
        // TODO 1: return true if rank is EIGHT
        if (cardToPlay.getRank() == Rank.EIGHT) return true;
        // TODO 2: check declared suit override (consider overloaded method)
        if (cardToPlay.getSuits() == topCard.getSuits()) return true;
        if (cardToPlay.getRank() == topCard.getRank()) return true;
        return false;
    }

    public static boolean isValidPlay(Card cardToPlay, Card topCard, Suits declaredSuit) {
        if (cardToPlay.getRank() == Rank.EIGHT) return true;
        if (declaredSuit != null) {
            return cardToPlay.getSuits() == declaredSuit;
        }
        if (cardToPlay.getSuits() == topCard.getSuits()) return true;
        if (cardToPlay.getRank() == topCard.getRank()) return true;
        return false;
    }

    // -------------------------------------------------------------------------
    // Initial deal
    // -------------------------------------------------------------------------

    /**
     * Return how many cards each player should receive at the start of the game.
     *
     * TODO 4 — Standard rule
     *   - Crazy Eights standard: 7 cards for 2 players, 5 cards for 3+ players.
     *   - Implement the condition and return the correct number.
     *
     * @param playerCount number of players in the game
     * @return cards to deal per player
     */
    public static int initialHandSize(int playerCount) {
        // TODO 4: return 7 if playerCount == 2, else return 5
        if (playerCount == 2) return 7;
        return 5; // placeholder
    }

    // -------------------------------------------------------------------------
    // Win condition
    // -------------------------------------------------------------------------

    /**
     * Check whether a player has won (empty hand).
     *
     * TODO 5 — Implement win check
     *   - Return true if player.getHand().size() == 0.
     *
     * @param player the player to check
     * @return true if the player's hand is empty
     */
    public static boolean hasWon(Player player) {
        // TODO 5: check hand size
        return player.getHand().getCards().isEmpty();

    }

    // -------------------------------------------------------------------------
    // Score calculation (optional / stretch goal)
    // -------------------------------------------------------------------------

    /**
     * Calculate the penalty points remaining in a player's hand.
     *
     * TODO 6 — Point values (standard scoring)
     *   - Eight  → 50 points
     *   - Face cards (Jack, Queen, King) → 10 points each
     *   - Ace    → 1 point
     *   - Number cards → face value (TWO=2, THREE=3, … TEN=10)
     *
     * Iterate over player.getHand().getCards() and sum up the values.
     *
     * @param player the player whose hand is scored
     * @return total penalty points
     */
    public static int calculateHandScore(Player player) {
        // TODO 6: iterate hand, sum penalty points per card
        return player.getHand().getCards().stream().mapToInt(card -> card.getRank().getValue()).sum();
    }
}