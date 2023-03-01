package transactions;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;


public class Carrier {
    private String carrierName;
    private Set<Region> regions = new TreeSet<>(Comparator.comparing(Region::getName).reversed());

    public Carrier(String carrierName, String[] regionNames) {
        this.carrierName = carrierName;
    }

    public String getCarrierName() {
        return carrierName;
    }
    public void addRegion(Region region) {

    }

    @Override
    public String toString() {
        return "Carrier{" +
                "carrierName='" + carrierName + '\'' +
                ", regions=" + regions +
                '}';
    }

    public Region[] getRegions() {
        return new Region[0];
    }
}
