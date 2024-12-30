package Exceptions;

import utility.ExceptionMessages;

public class NotAValidLongitudeException extends Exception{
    public NotAValidLongitudeException(double longitude) {
        super(String.format(ExceptionMessages.NOT_A_VALID_LONGITUDE_MESSAGE, longitude));

    }
}
