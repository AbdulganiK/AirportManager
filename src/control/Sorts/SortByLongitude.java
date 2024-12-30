package control.Sorts;

import model.Airport;

import java.util.Comparator;

public class SortByLongitude implements Comparator<Airport> {
    @Override
    public int compare(Airport o1, Airport o2) {
        return Double.compare(o1.getPosition().getLongitude(), o2.getPosition().getLongitude());
    }
}