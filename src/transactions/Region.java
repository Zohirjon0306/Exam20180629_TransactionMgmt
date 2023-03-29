package transactions;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Region {

    private Set<String> places = new HashSet<>();
    private String name;

    public Region(String name, String...place) {
        this.name = name;
        this.places.addAll(Stream.of(place).collect(Collectors.toList()));
    }

    public String getName() {
        return this.name;
    }

    public Set<String> getPlaces(){
        return this.places;
    }
}
