package netid.iastate.edu.stopwatch;

import android.os.SystemClock;
import android.util.Log;

/**
 * A stopwatch that keeps time with simple start, stop, and reset operations.
 */
class StopwatchModel {
    /** Whether the stopwatch is currently running (counting time) or stopped. */
    private boolean mRunning = false;

    // TODO: Create any instance variables you need to track the time.
    // Hint: use SystemClock.elapsedRealtime() to track time between start and stop events.
    private long startTime = 0;
    private long pauseTime = 0;
    private long stopTime = 0;


    /**
     * A getter for the stopwatch's current state.
     * @return true if the stopwatch is running; false otherwise
     */
    public boolean isRunning() {
        return mRunning;
    }

    /**
     * Starts the stopwatch counting. This counts from where the stopwatch left off counting, unless
     * it was reset to 0.
     */
    public void start() {
        // TODO
        mRunning = true;
        if(stopTime == 0) {
            startTime = SystemClock.elapsedRealtime();
        }

        else {
            pauseTime += SystemClock.elapsedRealtime() - stopTime;
        }
    }

    /**
     * Stops the stopwatch's counting, effectively pausing the current time value.
     */
    public void stop() {
        // TODO
        mRunning = false;
        stopTime = SystemClock.elapsedRealtime();
    }

    /**
     * Resets the elapsed time to 0.
     */
    public void reset() {
        startTime = 0;
        pauseTime = 0;
        stopTime = 0;
    }

    public long getTimeElapsed() {
        if(isRunning()) {
            return SystemClock.elapsedRealtime() - startTime - pauseTime;
        }

        else {
            return stopTime - startTime - pauseTime;
        }
    }
}
