package SoalPrepFastTrack4;

public class Card {

    private Suits suit;
    private Rank rank;

    public Card (Suits suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
        
    }

    public Suits getSuits() {
        return this.suit;
    }

    public Rank getRank() {
        return this.rank;
    }

    @Override
    public String toString() {
        return rank.toString() + " " + suit.getSymbol();
    }
}
