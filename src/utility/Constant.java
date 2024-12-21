package utility;

/**
 * The Constant interface defines a set of constant values that are used across the application.
 * These constants include a standard file path, file extension, and an exit code for exceptions.
 *
 * STANDARD_PATH: Represents the default path to the CSV file used in the application.
 * CSV_EXTENSION: Specifies the expected file extension for CSV files.
 * EXCEPTION_EXIT: Defines the exit code used when the program encounters an exception.
 *
 * This interface is intended to centralize commonly used constant values
 * for better maintainability and to avoid hard-coded values in the codebase.
 */
public interface Constant {
    String STANDARD_PATH = "src/resources/airports.csv";
    String CSV_EXTENSION = ".csv";
    int EXCEPTION_EXIT = -1;
    String SEPARATOR = ",";
    int startCountryISOString = 0;
    int endCountryISOString = 2;
}
