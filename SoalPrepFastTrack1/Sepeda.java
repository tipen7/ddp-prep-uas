package SoalPrepFastTrack1;

public abstract class Sepeda {

    private String name;
    private double price;
    private double wheelSize;
    private Material material;
    private Wheels wheels;


    public Sepeda(String name, double price, double wheelSize, Material material, Wheels wheels) {
        this.name = name;
        this.price = price;
        this.wheelSize =  wheelSize;
        this.material = material;
        this.wheels = wheels;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public double getWheelSize() {
        return this.wheelSize;
    }

    public Material getMaterial() {
        return this.material;
    }

    public Wheels getWheels() {
        return this.wheels;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setWheelSize(double wheelSize) {
        this.wheelSize = wheelSize;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setWheels(Wheels wheels) {
        this.wheels = wheels;
    }

    @Override
    public String toString() {
        return 
        "Nama Sepeda: " + this.name + "\n" +
        "Harga: " + this.price + "\n" +
        "Ukuran roda: " + this.wheelSize + "\n" +
        "Material: " + this.material + "\n" +
        "Jumlah roda: " + this.wheelSize + "\n";
    }


    
}
