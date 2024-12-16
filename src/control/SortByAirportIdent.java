package control;

import model.Airport;

import java.util.Comparator;

public class SortByAirportIdent implements Comparator<Airport> {
    @Override
    public int compare(Airport o1, Airport o2) {
        return o1.getId().getAirport_ident().compareTo(o2.getId().getAirport_ident());
    }
}
