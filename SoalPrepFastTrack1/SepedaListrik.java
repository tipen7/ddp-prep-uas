package SoalPrepFastTrack1;

public class SepedaListrik extends Sepeda {
    
    private double batteryCapacity;
    private double voltage;

    public SepedaListrik(String name, double price, double wheelSize, Material material, Wheels wheels, double batteryCapacity, double voltage) {
        super(name, price, wheelSize, material, wheels);
        this.batteryCapacity = batteryCapacity;
        this.voltage = voltage;
    }

    public double getVoltage() {
        return this.voltage;
    }

    public double getBatteryCapacity() {
        return this.batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    @Override
    public String toString() {
        return super.toString() +
        "Kapasitas baterai: " + this.batteryCapacity + "\n" +
        "Voltase: " + this.voltage + "\n";
    }
}
