package SoalSimulasiUAS2;

public class Beverage extends MenuItem{
    private String description;
    private int meidoBonusPoints;

    public Beverage(String name, double price, Type type, String description, int meidoBonusPoints) {
        super(name, price, type);
        this.description = description;
        this.meidoBonusPoints = 0;
        this.meidoBonusPoints = meidoBonusPoints;
    }

    @Override
    public String getInfoDetail() {
        return this.getName() + "\n" +
                this.description + "\n" +
                "harga: " + this.getPrice() + "\n" + " IDR"+
                "bonus: " + this.meidoBonusPoints + "\n";
    }

    @Override
    public String getInfoConcise() {
        return this.getName() + "\n" +
                this.description + "\n" +
                "harga: " + this.getPrice() + "\n" + " IDR"+
                "bonus: " + this.meidoBonusPoints + "\n";
    }
}
