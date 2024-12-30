package control.Sorts;


import model.Airport;

import java.util.Comparator;

public class SortByMunicipality implements Comparator<Airport> {
    @Override
    public int compare(Airport o1, Airport o2) {
        return o1.getLocation().getMunicipality().compareTo(o2.getLocation().getMunicipality());
    }
}
