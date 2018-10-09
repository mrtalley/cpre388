package netid.iastate.edu.gestures;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Main activity which represents the middle view.
 */
public class MainActivity extends CustomGestureListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setLeftRight(ThirdActivity.class, SecondActivity.class);

        View view = findViewById(R.id.mainView);
        View root = view.getRootView();

        Intent intentExtras = getIntent();

        if(intentExtras.hasExtra("swipe")) {
            String direction = intentExtras.getStringExtra("swipe");

            if(direction.equals("right")) {
                root.setBackgroundColor(getResources().getColor(R.color.colorOne));
            } else if(direction.equals("left")) {
                root.setBackgroundColor(getResources().getColor(R.color.colorTwo));
            }
        }
    }
}
