package SoalPrepFastTrack1;

public class SepedaGunung extends Sepeda {

    private Suspensi suspension;

     public SepedaGunung(String name, double price, double wheelSize, Material material, Wheels wheels, Suspensi suspesion) {
        super(name, price, wheelSize, material, wheels);
        this.suspension = suspesion;
    }

    public Suspensi getSuspension() {
        return this.suspension;
    }

    public void setSuspension(Suspensi suspension) {
        this.suspension = suspension;
    }

    @Override
    public String toString() {
        return super.toString() +
        "Suspensi: " + this.suspension + "\n";
    }
    
}
