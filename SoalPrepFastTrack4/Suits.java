package SoalPrepFastTrack4;

public enum Suits {
    DIAMOND("\u2666"),
    SPADE("\u2660"),
    HEART("\u2665"),
    CLUB("\\u2663");


    private String symbol;

    Suits(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }
}
