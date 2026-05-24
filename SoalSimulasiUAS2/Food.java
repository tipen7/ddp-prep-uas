package SoalSimulasiUAS2;

public class Food extends MenuItem{

    private String description;
    private int meidoBonusPoints;

    public Food(String name, double price, Type type, String description, int meidoBonusPoints) {
        super(name, price, type);
        this.description = description;
        this.meidoBonusPoints = meidoBonusPoints;
    }

    @Override
    public String getInfoDetail() {
        return this.getName() + "\n" +
                this.description + "\n" +
                "harga: " + this.getPrice() + " IDR" + "\n" +
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
