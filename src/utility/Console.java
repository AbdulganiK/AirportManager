package utility;
import java.time.LocalTime;

public class Console {
    /**
     * @precondition a message have to be given
     * @postcondition the message should be printed inside the terminal with the time
     * @param message string which should be printed inside terminal
     */
    public static void log (String message) {
        System.out.println(getTimeNow() + " " + message);
    }
    private static String getTimeNow() {
        LocalTime localTime = LocalTime.now();
        return String.format("%02d:%02d:%02d:", localTime.getHour(), localTime.getMinute(), localTime.getSecond());
    }
}
