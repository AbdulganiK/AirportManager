package Exceptions;

import utility.ExceptionMessages;

public class NotAValidElevationException extends Exception {
    public NotAValidElevationException(long elevation) {
        super(String.format(ExceptionMessages.NOT_A_VALID_ELEVATION_MESSAGE, elevation));
    }
}
