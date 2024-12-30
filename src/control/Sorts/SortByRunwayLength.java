package control.Sorts;

import model.Airport;

import java.util.Comparator;

public class SortByRunwayLength implements Comparator<Airport> {
    @Override
    public int compare(Airport o1, Airport o2) {
        return Long.compare(o1.getRunway().getLength(), o2.getRunway().getLength());
    }
}
