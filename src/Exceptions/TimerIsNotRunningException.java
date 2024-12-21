package Exceptions;

import utility.ExceptionMessages;

public class TimerIsNotRunningException extends Exception {
    public TimerIsNotRunningException() {
        super(ExceptionMessages.TIMER_IS_NOT_STARTED_MESSAGE);

    }
}
