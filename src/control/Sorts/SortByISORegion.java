package control.Sorts;

import model.Airport;

import java.util.Comparator;

public class SortByISORegion implements Comparator<Airport> {
    @Override
    public int compare(Airport o1, Airport o2) {
        return o1.getLocation().getRegion().compareTo(o2.getLocation().getRegion());
    }
}
