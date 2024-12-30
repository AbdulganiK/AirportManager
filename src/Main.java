import control.AirportController;
import control.AirportFactory;
import control.DataValidationController;
import model.Airport;
import utility.AirportCSVFileReader;
import utility.RegexPatterns;

import java.util.ArrayList;

/**
 * Main Class for all Tasks
 * Task1
 * Task2
 * Task3
 * Task4
 * Task5
 *
 * All tasks are static and can be directly called in main method
 */
public class Main {
    public static void main(String[] args) {
        task4(
                task3(
                        task2(
                                task1())));
    }

    /**
     * @precondition method called in main method
     * @postcondition task1 is executed
     * @return ArrayList<String> raw_data
     */
    private static ArrayList<String> task1 () {
        AirportCSVFileReader reader = new AirportCSVFileReader();
        return reader.readFile();
    }

    private static ArrayList<Airport> task2(ArrayList<String> rawData) {
        return new AirportFactory().buildAirports(
                new DataValidationController(rawData)
                        .validateData());
    }

    public static AirportController task3(ArrayList<Airport> airports) {
        AirportController controller = new AirportController(airports);
        controller.sortAirportsByLongitude();
        controller.sortAirportsByType();
        controller.sortAirportsByCountry();
        controller.sortAirportsBySurface();
        controller.sortAirportsByID();
        controller.sortAirportsByElevation();
        controller.sortAirportsByContinent();
        controller.sortAirportsByLength();
        controller.sortAirportsByWidth();
        controller.sortAirportsByWidth();
        controller.sortAirportsByIdent();
        controller.sortAirportsByMunicipality();
        controller.sortAirportsByName();
        controller.sortAirportsByRegion();
        controller.sortAirportsByLatitude();
        return controller;
    }

    public static void task4(AirportController controller) {
        Airport airportWithTheSmallestRunwayWidthInNewZeeland = controller.getAirportWithSmallestRunwayWidthInNewZeeland();
        Airport airportWithTheSmallestRunwayLengthLightedInGermany = controller.getAirportWithSmallestRunwayLengthLightedInGermany();
        int amountOfAirportsInAustralia = controller.getAirportAmountInAustralia();
        long sumOfLightedAirportLengthsInAfrica = controller.getSumOfLightedAirportsInAfrica();
    }






}