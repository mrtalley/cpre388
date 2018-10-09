package netid.iastate.edu.stopwatch;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Formatter;

/**
 * Stopwatch activity.  This acts as an MVC Controller.
 */
public class MainActivity extends AppCompatActivity {
    /**
     * REFRESH_RATE defines how often we should update the timer to show how much time has elapsed.
     * refresh every 100 milliseconds
     */
    private final int REFRESH_RATE = 100;
    /**
     * The stopwatch model instance that will keep time.
     */
    private StopwatchModel mStopwatch;
    /**
     * A Handler for interfacing with the main thread's MessageQueue. This is not a HandlerThread,
     * because we don't need a background thread. Use this when to post delayed Runnables to the
     * main/UI thread.
     */
    private Handler mHandler;

    // TODO: create instance variables for any View and ViewGroup object you regularly need to
    // access.  Don't forget to set them in onCreate().

    private ViewGroup startResetGroup;
    private ViewGroup stopGroup;
    private TextView timer;
    private TextView tenthsTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStopwatch = new StopwatchModel();
        // https://developer.android.com/reference/android/os/Handler
        // Creating a new Handler with no arguments binds it to the current thread's event Looper,
        // which is the main thread.
        mHandler = new Handler();
        // TODO: update the UI with the initial state of the stopwatch

        startResetGroup = findViewById(R.id.startResetGroup);
        stopGroup = findViewById(R.id.stopGroup);
        timer = findViewById(R.id.timer);
        tenthsTimer = findViewById(R.id.tenthsTimer);
    }

    /**
     * This method starts the current stopwatch clock.
     *
     * @param view the calling View
     */
    public void onStartClick(View view) {
        // TODO
        mStopwatch.start();
        updateButtonState();
        mHandler.postDelayed(startTimer, REFRESH_RATE);
    }

    /**
     * This method resets the current stopwatch clock to 0.
     *
     * @param view the calling View
     */
    public void onResetClick(View view) {
        // TODO
        mStopwatch.reset();
        updateTimerDisplay();
    }

    /**
     * This method will stop the current stopwatch.
     *
     * @param view the calling View
     */
    public void onStopClick(View view) {
        // TODO
        // You need to stop the recurring UI update events here.  One simple way to do this is to
        // remove any pending Runnables in the UI thread by using mHandler.
        // Using the documentation, you can find an appropriate function:
        // https://developer.android.com/reference/android/os/Handler#removeCallbacks(java.lang.Runnable)
        mStopwatch.stop();
        updateButtonState();
        mHandler.removeCallbacks(startTimer);
    }

    /**
     * If the stopwatch is running, this method will show the stop button and hide the start and
     * reset buttons.
     * If the stopwatch is not running, this method will hide the stop button and show the start and
     * reset buttons.
     */
    private void updateButtonState() {
        // Hint: On a View or ViewGroup use setVisibility(int)
        // https://developer.android.com/reference/android/view/View#setVisibility(int)
        if (mStopwatch.isRunning()) {
            startResetGroup.setVisibility(View.GONE);
            stopGroup.setVisibility(View.VISIBLE);
        }

        else {
            stopGroup.setVisibility(View.GONE);
            startResetGroup.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Converts the elapsed given time and updates the display
     */
    private void updateTimerDisplay() {
        long timeElapsed = mStopwatch.getTimeElapsed();
        // Convert the milliseconds, seconds, minutes, and hours to String and format to ensure it
        // has leading zeros where required.  A good way to do this is use String.format().
        // From the documentation: https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html
        // A format specifier has the syntax:  %[flags][width]conversion

        Log.v("TIME", String.valueOf(timeElapsed));


        String mainDisplay = String.format("%tT", timeElapsed);

        Log.v("mainDisplay", mainDisplay);


        int millis = (int) timeElapsed / 100;

        String tenthsDisplay = String.format("%d", millis);
        tenthsDisplay = tenthsDisplay.substring(tenthsDisplay.length() - 1, tenthsDisplay.length());
        tenthsDisplay = String.format(".%s", tenthsDisplay);

        // Set the timer display text to the elapsed time.
        timer.setText(mainDisplay);
        tenthsTimer.setText(tenthsDisplay);
    }

    /**
     * Create a Runnable startTimer that makes timer runnable.
     */
    private Runnable startTimer = new Runnable() {
        public void run() {
            // TODO: Update the UI and trigger this runnable again in the future.
            mHandler.postDelayed(this, REFRESH_RATE);

            // TODO: calculate the time elapsed and update the displayed time
            updateTimerDisplay();
        }
    };
}
