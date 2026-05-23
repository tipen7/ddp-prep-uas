package SoalPrepFastTrack1;
import java.util.ArrayList;
import java.util.List;

public class TokoSepeda<T extends Sepeda> {

    private List<T> bicycles;

    public TokoSepeda() {
        this.bicycles = new ArrayList<>();
    }

    public List<T> getBicycle() {
        return this.bicycles;
    }

    public int getBicycleCount() {
        return this.bicycles.size();
    }
    
    
}
