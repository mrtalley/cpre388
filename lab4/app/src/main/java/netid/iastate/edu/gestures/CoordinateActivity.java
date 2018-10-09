package netid.iastate.edu.gestures;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * This Activity shows touch information on a TextView.
 */
public class CoordinateActivity extends Activity {
    TextView coordinateText;
    LinearLayout coordinateView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinate);
        coordinateText = findViewById(R.id.coordinateText);

        //TODO - set a touch listener for the (linear) layout to a new instance of the class below.
        coordinateView = findViewById(R.id.coordinateView);
        MotionListener motionListener = new MotionListener();
        coordinateView.setOnTouchListener(motionListener);
    }

    //TODO - Create a private class that implements View.OnTouchListener.
    //TODO - Override the onTouch method and implement logic that checks for a moving action and if
    // true, updates (set) the TextView in the layout to display the ( x , y ) coordinates of the
    // moving finger

    private class MotionListener implements View.OnTouchListener {
        @Override
        public  boolean onTouch(View v, MotionEvent e) {
            float x = (int) e.getX();
            float y = (int) e.getY();

            switch(e.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    writeText("Finger down");
                    Log.v("DOWN", "");
                    break;
                case MotionEvent.ACTION_MOVE:
                    writeCoordinates(x, y);
                    Log.v("MOVE", "");

                    break;
                case MotionEvent.ACTION_UP:
                    writeText("Finger up");
                    Log.v("UP", "");
                    break;
            }

            return true;
        }
    }

    private void writeCoordinates(float x, float y) {
        coordinateText.setText("(" + Float.toString(x) + ", " + Float.toString(y) + ")");
    }

    private void writeText(String text) {
        coordinateText.setText(text);
    }

}
