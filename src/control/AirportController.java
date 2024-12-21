package control;

import model.Airport;

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
     * @precondition airport should be valid
     * @postcondition airport is added to the airports attribute
     * @param airport object which should be added to the controller
     */
    public void addAirport(Airport airport) {
        this.airports.add(airport);
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

    /**
     * @precondition an aiport which is existing in the airports attribute
     * @postcondition the airport does not exist in the airports anymore
     * @param airport object which should be removed
     */
    public void deleteAirport(Airport airport) {
        this.airports.remove(airport);
    }




}
