package control;

import control.Sorts.*;
import model.Airport;
import model.Continent;
import model.Country;
import model.Type;

import java.util.ArrayList;


/**
 * The AirportController class is responsible for managing a collection of airports.
 * It provides methods to add and remove airports from the collection.
 */
public class AirportController {
    private ArrayList<Airport> airports = new ArrayList<>();

    /**
     * Constructor for creating an AirportController. The to be managed Airports can be
     * added over the Constructor or later over the addAirports method.
     * The AirportController is able to sort, add, remove Airports from his list
     * @precondition  all airport objects have to be valid
     * @postcondition airports are added to the airports attribute
     * @param airports objcets which should be added to the controller
     */
    public AirportController(ArrayList<Airport> airports) {
        this.addAirports(airports);
    }

    /**
     * Method to add airports.
     * @precondition all airports have to be valid
     * @postcondition airports are added to the airports attribute
     * @param airports ArrayList<Airport> which should be added to the airports attribute
     */
    public void addAirports(ArrayList<Airport> airports) {
        this.airports.addAll(airports);
    }

    public ArrayList<Airport> filterAirportsByType(Type type) {
        ArrayList<Airport> filteredAirports = new ArrayList<>();
        for (Airport airport : this.getAirports()) {
            if (airport.getType().equals(type)) {
                filteredAirports.add(airport);
            }
        }
        return filteredAirports;
    }

    public ArrayList<Airport> filterAirportsByLightingStatus(boolean status) {
        ArrayList<Airport> filteredAirports = new ArrayList<>();
        for (Airport airport : this.getAirports()) {
            if (airport.getRunway().getLighting().getStatus() == status) {
                filteredAirports.add(airport);
            }
        }
        return filteredAirports;
    }

    public ArrayList<Airport> filterAirportsByCountry(Country country) {
        ArrayList<Airport> filteredAirports = new ArrayList<>();
        for (Airport airport : this.getAirports()) {
            if (airport.getLocation().getCountry().equals(country)) {
                filteredAirports.add(airport);
            }
        }
        return filteredAirports;
    }

    public Airport getAirportWithSmallestRunwayWidthInNewZeeland() {
        this.sortAirportsByWidth();
        ArrayList<Airport> airportsNewZeeland =  this.filterAirportsByCountry(Country.NZ);
        return airportsNewZeeland.getFirst();
    }

    public Airport getAirportWithSmallestRunwayLengthLightedInGermany() {
        this.sortAirportsByLength();
        ArrayList<Airport> airportsGermany = this.filterAirportsByCountry(Country.DE);
        for (Airport airport : airportsGermany) {
            if (airport.getRunway().getLighting().getStatus()) {
                return airport;
            }
        }
        return null;
    }

    public int getAirportAmountInAustralia() {
        return filterAirportsByCountry(Country.AU).size();
    }

    public ArrayList<Airport> getAirports() {
        return airports;
    }

    public static ArrayList<Airport> filterAirportsByContinent(ArrayList<Airport> airports, Continent continent) {
        ArrayList<Airport> filteredAirports = new ArrayList<>();
        for (Airport airport : airports) {
            if (airport.getLocation().getContinent().equals(continent)) {
                filteredAirports.add(airport);
            }
        }
        return filteredAirports;
    }

    public long getSumOfLightedAirportsInAfrica() {
        ArrayList<Airport> lightedAirports = filterAirportsByLightingStatus(true);
        ArrayList<Airport> lightedAirportsInAfrica = filterAirportsByContinent(lightedAirports, Continent.AF);
        long sumOfRunwayLengths = 0;
        for (Airport airport: lightedAirportsInAfrica) {
            sumOfRunwayLengths += airport.getRunway().getLength();
        }
        return sumOfRunwayLengths;
    }

    public ArrayList<Airport> sortAirportsByName() {
        ArrayList<Airport> airports = this.getAirports();
        airports.sort(new SortByName());
        return airports;
    }

    public ArrayList<Airport> sortAirportsByID() {
        ArrayList<Airport> airports = this.getAirports();
        airports.sort(new SortByID());
        return airports;
    }

    public ArrayList<Airport> sortAirportsByIdent() {
        ArrayList<Airport> airports = this.getAirports();
        airports.sort(new SortByAirportIdent());
        return airports;
    }

    public ArrayList<Airport> sortAirportsByContinent() {
        ArrayList<Airport> airports = this.getAirports();
        airports.sort(new SortByContinent());
        return airports;
    }

    public ArrayList<Airport> sortAirportsByElevation() {
        ArrayList<Airport> airports = this.getAirports();
        airports.sort(new SortByElevation());
        return airports;
    }

    public ArrayList<Airport> sortAirportsByCountry() {
        ArrayList<Airport> airports = this.getAirports();
        airports.sort(new SortByElevation());
        return airports;
    }

    public ArrayList<Airport> sortAirportsByRegion() {
        ArrayList<Airport> airports = this.getAirports();
        airports.sort(new SortByISORegion());
        return airports;
    }

    public ArrayList<Airport> sortAirportsByMunicipality() {
        ArrayList<Airport> airports = this.getAirports();
        airports.sort(new SortByMunicipality());
        return airports;
    }

    public ArrayList<Airport> sortAirportsByLength() {
        ArrayList<Airport> airports = this.getAirports();
        airports.sort(new SortByRunwayLength());
        return airports;
    }

    public ArrayList<Airport> sortAirportsByWidth() {
        ArrayList<Airport> airports = this.getAirports();
        airports.sort(new SortByRunwayWidth());
        return airports;
    }

    public ArrayList<Airport> sortAirportsBySurface() {
        ArrayList<Airport> airports = this.getAirports();
        airports.sort(new SortByRunWaySurface());
        return airports;
    }

    public ArrayList<Airport> sortAirportsByType() {
        ArrayList<Airport> airports = this.getAirports();
        airports.sort(new SortByType());
        return airports;
    }

    public ArrayList<Airport> sortAirportsByLongitude() {
        ArrayList<Airport> airports = this.getAirports();
        airports.sort(new SortByLongitude());
        return airports;
    }

    public ArrayList<Airport> sortAirportsByLatitude() {
        ArrayList<Airport> airports = this.getAirports();
        airports.sort(new SortByLatitude());
        return airports;
    }

}
