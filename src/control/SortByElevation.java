package control;

import model.Airport;

import java.util.Comparator;

public class SortByElevation implements Comparator<Airport> {
    @Override
    public int compare(Airport o1, Airport o2) {
        return Double.compare(o1.getElevation(), o2.getElevation());
    }
}
