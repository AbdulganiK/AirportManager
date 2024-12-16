package utility;

import Exceptions.TimerIsAlreadyRunningException;
import Exceptions.TimerIsNotRunningException;

public class Timer {
    private long startTime = 0L;
    private long stopTime = 0L;

    private void resetTimer() {
        this.startTime = 0L;
        this.stopTime = 0L;

    }

    public void start() {
        try {
            if (this.startTime == 0L) {
                this.startTime = System.nanoTime();
            } else {
                throw new TimerIsAlreadyRunningException();
            }
        } catch (TimerIsAlreadyRunningException e) {
            Console.log(e.getMessage());
        }


    }

    public long stop() {
        try {
            if (this.startTime == 0L) {
                throw new TimerIsNotRunningException();
            } else {
                this.stopTime = System.nanoTime();
            }
            long duration = this.stopTime - this.startTime;
            this.resetTimer();
            return duration;
        } catch (TimerIsNotRunningException e) {
            Console.log(e.getMessage());
        }
        return -1L;
    }


}
