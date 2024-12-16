package Exceptions;

import utility.ExceptionMessages;

public class NotACSVFileException extends Exception{
    public NotACSVFileException() {
        super(ExceptionMessages.NOT_A_CSV_FILE_MESSAGE);
    }
}
