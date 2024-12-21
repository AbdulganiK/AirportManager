package control;

import model.Airport;

import java.util.ArrayList;

/**
 * A factory class for creating Airport objects.
 * This class provides methods to build a single Airport or a list of Airports
 * from a validated data set.
 */
public class AirportFactory {

    /**
     * Builds a single Airport object using the provided validated data set.
     * @precondition `validatedDataSet` must not be null or empty or must contain data in the correct format for creating an Airport..
     * @postcondition If the input is valid, an Airport object is created and returned
     * @param validatedDataSet A string containing the validated data for creating the Airport.
     * @return An Airport object created using the provided data, or null if the input is invalid.
     */
    public static Airport buildAirport(String validatedDataSet) {
        // TODO: Implement the logic for building a single Airport object
        return null;
    }

    /**
     * @precondition The `validatedData` must not be null or empty, must contain data in the correct format for creating multiple Airport.
     * @postcondition If the input is valid, a non-null ArrayList of Airport objects is created and returned.If the input is invalid, the method returns null or an empty list (depending on the implementation).
     * @param validatedData A string containing the validated data for creating multiple Airports.
     * @return An ArrayList of Airport objects created using the provided data, or null/empty list if the input is invalid.
     */
    public static ArrayList<Airport> buildAirports(String validatedData) {
        // TODO: Implement the logic for building a list of Airport objects
        return null;
    }
}
