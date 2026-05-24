package SoalPrepFastTrack4;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Player {

    private Hand hand;
    private String name;
    private Suits declaredSuit;

    public Player(String name) {
        this.hand = new Hand();
        this.name = name;
    }

    /**
     * Draw a card from the deck and add it to the player's hand.
     * Already implemented — catches EmptyDeckException gracefully.
     */
    public void drawCard(Deck deck) {
        try {
            Card drawedCard = deck.draw();
            this.hand.addCard(drawedCard);
        } catch (EmptyDeckException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Attempt to play a card from this player's hand onto the discard pile.
     *
     * TODO 1 — Find playable cards
     *   - Use GameRules.isValidPlay(candidate, topCard) to filter the hand.
     *   - Collect all valid candidates into a List<Card>.
     *   - If the list is empty, the player has no legal move (see TODO 3).
     *
     * TODO 2 — Choose which card to play
     *   - For a human player: print the valid cards with their index and read
     *     the player's choice via a Scanner.
     *   - For an AI / auto player (optional stretch): pick the first valid card,
     *     or implement a simple strategy (e.g. prefer non-eights).
     *
     * TODO 3 — Handle no valid play
     *   - If there are no playable cards, the player must draw from the deck.
     *   - Call drawCard(deck) and return without placing anything on the pile.
     *   - Tip: you may want to try drawing up to N times (house rule) or just once.
     *
     * TODO 4 — Handle playing an Eight (the wild card)
     *   - If the chosen card's rank is EIGHT, prompt the player to declare
     *     a new suit (DIAMOND, SPADE, HEART, CLUB).
     *   - Store the declared suit so TurnManager / GameRules can enforce it
     *     on the very next turn.
     *   - Suggestion: add a field `private Suits declaredSuit` and a getter.
     *
     * TODO 5 — Remove the card from hand and place it on the discard pile
     *   - Call hand.removeCard(chosenCard).
     *   - Call discardPile.addCard(chosenCard).
     *
     * TODO 6 — Victory check
     *   - After playing, check if hand.size() == 0.
     *   - If so, print a win message or signal the TurnManager that this player won.
     *
     * @param topCard     the current top card of the discard pile (used for validation)
     * @param discardPile the discard pile to place the chosen card onto
     * @param deck        the draw deck, used if the player cannot play
     */
    public void playCard(Card topCard, DiscardPile discardPile, Deck deck) throws EmptyDeckException {
        // TODO 1: filter hand for valid plays
        Card sameSuitedCard = this.hand.getCards().stream()
                                                  .filter(card -> card.getRank().getValue() != 8)
                                                  .filter(card -> card.getSuits().getName().equalsIgnoreCase(topCard.getSuits().getName()))
                                                  .findFirst()
                                                  .orElse(null);

        Card sameRankedCard = this.hand.getCards().stream()
                                                  .filter(card -> card.getRank().getValue() != 8)
                                                  .filter(card -> card.getRank() == topCard.getRank())
                                                  .findFirst()
                                                  .orElse(null);

        Card eightCard = this.hand.getCards().stream()
                                             .filter(card -> card.getRank().getValue() == 8)
                                             .findFirst()
                                             .orElse(null);

        // TODO 2: choose a card (user input or AI)
        Card chosenCard = null;
        if (sameSuitedCard != null) {
            chosenCard = sameSuitedCard;
        } else if (sameRankedCard != null) {
            chosenCard = sameRankedCard;

            // TODO 4: handle Eight — prompt for suit declaration
        } else if (eightCard != null) {
            chosenCard = eightCard;
            Scanner input = new Scanner(System.in);
            System.out.print("Enter a suit: ");
            String suit = input.nextLine().trim().toUpperCase();
            this.declaredSuit = Suits.valueOf(suit);

            // TODO 3: draw if no valid card exists
        } else {
            this.drawCard(deck);
            return;
        }

        // TODO 5: remove from hand, add to discard pile
        discardPile.addCard(chosenCard);
        this.hand.removeCard(chosenCard);

        // TODO 6: check for win condition
        if (this.hand.getCards().isEmpty()) {
            System.out.println(this.name + " has no empty cards yahoo!");
        }
    }

    public void playCard(Card topCard, DiscardPile discardPile, Deck deck, Suits declaredSuit) throws EmptyDeckException {

        Card sameSuitedCard = this.hand.getCards().stream()
                .filter(card -> card.getRank() != Rank.EIGHT)
                .filter(card -> GameRules.isValidPlay(card, topCard, declaredSuit))
                .findFirst().orElse(null);

        Card eightCard = this.hand.getCards().stream()
                .filter(card -> card.getRank() == Rank.EIGHT)
                .findFirst().orElse(null);

        Card chosenCard;

        if (sameSuitedCard != null) {
            chosenCard = sameSuitedCard;
            this.declaredSuit = null;
        } else if (eightCard != null) {
            chosenCard = eightCard;
            Scanner scanner = new Scanner(System.in);
            System.out.println("You played an Eight! Enter a suit (DIAMOND, SPADE, HEART, CLUB): ");
            this.declaredSuit = Suits.valueOf(scanner.nextLine().toUpperCase());
        } else {
            System.out.println(this.name + " has no valid card, drawing...");
            this.drawCard(deck);
            return;
        }

        this.hand.removeCard(chosenCard);
        discardPile.addCard(chosenCard);
        System.out.println(this.name + " played: " + chosenCard);

        if (this.hand.size() == 0) {
            System.out.println(this.name + " has no empty cards yahoo!");
        }
    }


    public Hand getHand() {
        return this.hand;
    }

    public String getName() {
        return this.name;
    }

    public Suits getDeclaredSuit() {
        return this.declaredSuit;
    }
}