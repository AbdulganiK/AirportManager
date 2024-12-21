package utility;

/**
 * The ExceptionMessages interface defines a set of constant string messages
 * that are used to represent exceptions or error states in the application.
 * These messages are customized with color coding for better visibility in logs.
 *
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

}
