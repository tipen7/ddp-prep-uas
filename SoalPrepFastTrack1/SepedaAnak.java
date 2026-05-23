package SoalPrepFastTrack1;

public class SepedaAnak extends Sepeda implements Berkeranjang {

    private int basketCount;
    private double basketCapacity;
    
    public SepedaAnak(String name, double price, double wheelSize, Material material, Wheels wheels, int basketCount, double basketCapacity) {
        super(name, price, wheelSize, material, wheels);
        this.basketCount = basketCount;
        this.basketCapacity = basketCapacity;
    }

    @Override
    public int getBasketCount() {
        return this.basketCount;
    }

    @Override
    public double getBasketCapacity() {
        return this.basketCapacity;
    }

    @Override
    public void setBasketCapacity(double basketCapacity) {
        this.basketCapacity = basketCapacity;
    }

    @Override
    public void setBasketCount(int basketCount) {
        this.basketCount = basketCount;
    }

    @Override
    public String toString() {
        return super.toString() +
        "Ukuran keranjang: " + this.basketCapacity + "\n" +
        "Banyak keranjang: " + this.basketCapacity + "\n";
    }
}
