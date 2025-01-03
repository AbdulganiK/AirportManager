package utility;

/**
 * The LogMessages interface contains commonly used log messages
 * formatted with ANSI color codes for console output.
 * These messages are designed to provide feedback about
 * operations such as reading files, dataset counts, and read durations.
 *
 * This interface is typically used in conjunction with logging utilities
 * or console output methods to standardize and colorize status messages.
 */
public interface LogMessages {
    String SUCCESSFULLY_READ_FILE = Colors.GREEN + "Die Datei wurde erfolgreich gelesen." + Colors.RESET;
    String DATASET_COUNT = Colors.GREEN + "Es wurden %d Datensätze eingelesen." + Colors.RESET;
    String DATASET_READ_DURATION =  Colors.GREEN + "Das Lesen der Datensätze hat %d Nanosekunden gedauert" + Colors.RESET;
    String DATASET_VALIDATED_COUNT = Colors.GREEN + "Es sind %d von %d Datensätze valide." + Colors.RESET;
    String AIRPORT_DELETED =  Colors.GREEN + "Es wurden %d Flughäfen gelöscht." + Colors.RESET;
    String AIRPORT_CREATED =  Colors.GREEN + "Es wurden %d Flughäfen erstellt." + Colors.RESET;
    String AIRPORT_CORRECTED =  Colors.GREEN + "Davon wurden %d Flughäfen korrigiert." + Colors.RESET;
}
