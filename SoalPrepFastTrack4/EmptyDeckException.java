package SoalPrepFastTrack4;

/**
 * Custom checked exception thrown when drawing from an empty Deck.
 *
 * TODO 1 — Extend the right parent class
 *   - Decide: should this be a checked exception (extends Exception)
 *     or an unchecked one (extends RuntimeException)?
 *   - For a card game where an empty deck is a recoverable situation
 *     (e.g. reshuffle discard pile back into deck), checked is appropriate.
 *   - Replace the placeholder below with your chosen parent.
 *
 * TODO 2 — Constructor(s)
 *   - Provide at least a single-argument constructor that accepts a String message
 *     and forwards it to super(message).
 *   - Optionally add a no-arg constructor with a sensible default message,
 *     and a two-arg constructor (String message, Throwable cause) for wrapping.
 *
 * Example skeleton:
 *
 *   public class EmptyDeckException extends Exception {
 *       public EmptyDeckException(String message) {
 *           super(message);
 *       }
 *   }
 */
public class EmptyDeckException extends Exception { // TODO 1: confirm/change parent class
    public EmptyDeckException(String msg) {
        super(msg);
    }
    // TODO 2: implement constructor(s) here
}