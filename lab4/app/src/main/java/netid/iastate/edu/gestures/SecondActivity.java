package netid.iastate.edu.gestures;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Activity which represents the right view.
 */
public class SecondActivity extends CustomGestureListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setLeftRight(MainActivity.class, ThirdActivity.class);

        View view = findViewById(R.id.secondActivity);
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