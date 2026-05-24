package SoalSimulasiUAS2;

public enum Type {
    FOOD("MAKANAN"),
    BEVERAGE("MINUMAN"),
    SONG("MUSIK");

    private final String type;
    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
