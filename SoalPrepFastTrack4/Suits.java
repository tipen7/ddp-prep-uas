package SoalPrepFastTrack4;

public enum Suits {
    DIAMOND("\u2666", "DIAMOND"),
    SPADE("\u2660", "SPADE"),
    HEART("\u2665", "HEART"),
    CLUB("\u2663", "CLUB");


    private String symbol;
    private String name;

    Suits(String symbol, String name) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }
    public String getName() {return this.name;}
}
