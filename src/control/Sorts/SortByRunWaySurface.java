package control.Sorts;

import model.Airport;

import java.util.Comparator;

public class SortByRunWaySurface implements Comparator<Airport> {
    @Override
    public int compare(Airport o1, Airport o2) {
        return o1.getRunway().getSurface().compareTo(o2.getRunway().getSurface());
    }
}
