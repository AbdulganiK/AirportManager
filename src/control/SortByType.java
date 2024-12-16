package control;

import model.Airport;

import java.util.Comparator;

public class SortByType implements Comparator<Airport> {
    @Override
    public int compare(Airport o1, Airport o2) {
        return o1.getType().compareTo(o2.getType());
    }
}