package utility;

/**
 * The ExceptionMessages interface defines a set of constant string messages
 * that are used to represent exceptions or error states in the application.
 * These messages are customized with color coding for better visibility in logs.
 * <p>
 * The constants include messages for:
 * - Invalid file types
 * - File not found issues
 * - Stopwatch-related errors (e.g., already running or not started)
 */
public interface ExceptionMessages {
    String NOT_A_CSV_FILE_MESSAGE = Colors.RED + "Die Datei ist keine .csv Datei" + Colors.RESET;
    String FILE_NOT_FOUND = Colors.RED + "Die Datei wurde nicht gefunden" + Colors.RESET;
    String TIMER_IS_ALREADY_RUNNING_MESSAGE = Colors.RED + "Die Stopuhr wurde bereits gestartet" + Colors.RESET;
    String TIMER_IS_NOT_STARTED_MESSAGE = Colors.RED + "Die Stopuhr wurde nicht gestartet" + Colors.RESET;
    String NOT_A_VALID_LATITUDE_MESSAGE = Colors.RED + "Der Wert %f liegt nicht im Definitionsbereich eines Breitengrads (" + Constant.MIN_LATITUDE_DEG + " <= x <= " + Constant.MAX_LATITUDE_DEG + ")" + Colors.RESET;
    String NOT_A_VALID_LONGITUDE_MESSAGE = Colors.RED + "Der Wert %f liegt nicht im Definitionsbereich eines Längengrads (" + Constant.MIN_LONGITUDE_DEG + " <= x <= " + Constant.MAX_LONGITUDE_DEG + ")" + Colors.RESET;
    String EMPTY_NUMBERS_MESSAGE = Colors.RED + "Die Liste darf nicht null oder leer sein." + Colors.RESET;
    String NOT_A_VALID_ELEVATION_MESSAGE = Colors.RED + "Der Wert %d liegt nicht im Definitionsbereich einer möglichen Höhenlage (" + Constant.MIN_ELEVATION_MM + " <= x <= " + Constant.MAX_ELEVATION_MM + ")" + Colors.RESET;
}
