package control;

import model.Airport;

import java.util.Comparator;

public class SortByISOCountry implements Comparator<Airport> {
    @Override
    public int compare(Airport o1, Airport o2) {
        return o1.getLocation().getCountry().compareTo(o2.getLocation().getCountry());
    }
}
