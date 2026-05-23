package SoalPrepFastTrack2;

public class InvalidRomeNumberException extends Exception {
    
    public InvalidRomeNumberException(String symbol) {
        super("Symbol " + symbol + " bukan huruf romawi yang valid");
    }
}
