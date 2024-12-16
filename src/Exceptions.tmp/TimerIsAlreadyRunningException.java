package Exceptions;

import utility.ExceptionMessages;

public class TimerIsAlreadyRunningException extends Exception {
    public TimerIsAlreadyRunningException() {
        super(ExceptionMessages.TIMER_IS_ALREADY_RUNNING_MESSAGE);
    }
}
