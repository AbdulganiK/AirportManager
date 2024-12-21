package utility;

import Exceptions.TimerIsAlreadyRunningException;
import Exceptions.TimerIsNotRunningException;

public class Timer {
    private long startTime = 0L;
    private long stopTime = 0L;

    /**
     * resetTimer sets the start and stop time back to 0L
     * @precondition a timer instance for calling this method
     * @postcondition start and stop time are set to 0;
     * @modifier void
     */
    private void resetTimer() {
        this.startTime = 0L;
        this.stopTime = 0L;

    }

    /**
     * Method for starting the timer
     * @precondition the timer needs to be not running
     * @postcondition the timer should be started
     */

    public void start() {
        try {
            // checking if the timer has started
            if (this.startTime == 0L) {
                // if timer is not started the timer will be started with the current time in nano seconds
                this.startTime = System.nanoTime();
            } else {
                // if timer is running throwing an exception
                throw new TimerIsAlreadyRunningException();
            }
        } catch (TimerIsAlreadyRunningException e) {
            // catching the thrown exception and logging the message
            Console.log(e.getMessage());
        }
    }

    /**
     * @precondition timer have to be started
     * @postcondition duration between start and stop
     * @return long duration between the start and stop
     */
    public long stop() {
        try {
            // throwing an exception when the timer is stopped without starting it before
            if (this.startTime == 0L) {
                throw new TimerIsNotRunningException();
            // seting the stop time in nano seconds
            } else {
                this.stopTime = System.nanoTime();
            }
            // calulationt the duration between start and stop
            long duration = this.stopTime - this.startTime;
            // resetting the timer for the next usage
            this.resetTimer();
            // returning the duration
            return duration;
        } catch (TimerIsNotRunningException e) {
            Console.log(e.getMessage());
        }
        return -1L;
    }


}
