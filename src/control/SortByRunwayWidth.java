package control;

import model.Airport;

import java.util.Comparator;

public class SortByRunwayWidth implements Comparator<Airport> {
    @Override
    public int compare(Airport o1, Airport o2) {
        return Double.compare(o1.getRunway().getWidth(), o2.getRunway().getWidth());
    }
}