package control.Sorts;

import model.Airport;
import java.util.Comparator;

public class SortByContinent implements Comparator<Airport> {
    @Override
    public int compare(Airport o1, Airport o2) {
        return o1.getLocation().getContinent().toString().compareTo(o2.getLocation().getContinent().toString());
    }
}
