package netid.iastate.edu.gestures;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.Toast;

/**
 * This is a base class for handling swipes in the application.
 */
abstract class CustomGestureListener extends Activity implements OnGestureListener {
    /**
     * The GestureDetector that processes onTouch events and raises events (callbacks) on this class.
     */
    private GestureDetector gestureDetector = null;
    /** The class for the Activity that should be shown to the left on a swipe. */
    private Class<? extends Activity> leftActivity = null;
    /** The class for the Activity that should be shown to the right on a swipe. */
    private Class<? extends Activity> rightActivity = null;
    /**
     * This is the key to use when storing and getting intent data ("extra") about the swipe direction
     */
    protected static final String KEY_INTENT_DIRECTION
            = "edu.iastate.netid.gestures.intent_direction";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Construct a GestureDetector that's attached to the current Activity. This tells the
        // GestureDetector which class instance to send events to (this).
        gestureDetector = new GestureDetector(getApplicationContext(), this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent me) {
        // Pass all touch events to the GestureDetector, which will raise events (callbacks) on this
        // class.
        return gestureDetector.onTouchEvent(me);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        //TODO - insert code here that:
        // distinguishes between left and right swipes
        // displays Toasts messages about the direction
        // navigates to left or right activity accordingly
        // creates an explicit intent accordingly
        // set the data on the intent of the direction, using KEY_INTENT_DIRECTION
        float e1X = e1.getX();
        float e2X = e2.getX();

        if(e1X < e2X) {
            Toast.makeText(this, "Left to Right Movement", Toast.LENGTH_LONG).show();
            Intent rightSwipe = new Intent(this, this.rightActivity);
            rightSwipe.putExtra("swipe", "right");
            startActivity(rightSwipe);
        }

        else if(e1X > e2X) {
            Toast.makeText(this, "Right to Left Movement", Toast.LENGTH_LONG).show();
            Intent leftSwipe = new Intent(this, this.leftActivity);
            leftSwipe.putExtra("swipe", "left");
            startActivity(leftSwipe);
        }

        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        //TODO - navigate to the CoordinateActivity with an explicit intent
        Intent longPressIntent = new Intent(this, CoordinateActivity.class);
        startActivity(longPressIntent);
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        // Auto-generated method stub
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        // Auto-generated method stub
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        // Auto-generated method stub
        return false;
    }

    /**
     * Sets the left and right activity classes which are swiped to
     *
     * @param leftActivity  The class for the left Activity
     * @param rightActivity The class for the right Activity
     */
    public void setLeftRight(Class<? extends Activity> leftActivity, Class<? extends Activity> rightActivity) {
        this.leftActivity = rightActivity;
        this.rightActivity = leftActivity;
    }

}

