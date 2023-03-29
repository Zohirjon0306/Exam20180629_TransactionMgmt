package transactions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Carrier {
    private String name;
    private Set<String> regions = new HashSet<>();
    private List<Transaction> transactions = new ArrayList<>();

    public List<Transaction> getTransactions() {
        return this.transactions;
    }

    public Carrier(String name, List<String> regions) {
        this.name = name;
        this.regions.addAll(regions);
    }

    public String getName() {
        return this.name;
    }

    public Set<String> getRegions(){
        return this.regions;
    }

}
