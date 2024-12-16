package control;

import model.Airport;

import java.util.Comparator;

public class SortByName implements Comparator<Airport> {
    @Override
    public int compare(Airport o1, Airport o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
