package control.Sorts;

import model.Airport;

import java.util.Comparator;

public class SortByID implements Comparator<Airport> {

    @Override
    public int compare(Airport o1, Airport o2) {
        return Integer.compare(o1.getId().getId(), o2.getId().getId());
    }
}
