package utility;
import java.time.LocalTime;

/**
 * The Console class provides a utility method for printing messages to the terminal,
 * formatted with the current time.
 * This is helpful for logging messages in applications where time-stamped logs are required.
 */
public class Console {
    /**
     * @precondition a message have to be given
     * @postcondition the message should be printed in the terminal with the current time
     * @param message string with the information
     */
    public static void log (String message) {
        System.out.println(getTimeNow() + " " + message);
    }
    private static String getTimeNow() {
        // instance of localtime now
        LocalTime localTime = LocalTime.now();
        return String.format("%02d:%02d:%02d:", localTime.getHour(), localTime.getMinute(), localTime.getSecond());
    }
}
