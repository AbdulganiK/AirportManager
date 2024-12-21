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
        task2(task1());
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
        DataValidationController dataController = new DataValidationController(rawData);
        ArrayList<String> validatedData = dataController.getValidatedData();
        System.out.println(validatedData.size());
        return null;

    }




}