package Exceptions;

import utility.ExceptionMessages;

public class NotAValidLatitudeException extends Exception{
    public NotAValidLatitudeException(double latitude) {
        super(String.format(ExceptionMessages.NOT_A_VALID_LATITUDE_MESSAGE, latitude));
    }
}
