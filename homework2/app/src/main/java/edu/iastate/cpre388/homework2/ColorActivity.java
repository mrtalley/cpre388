package edu.iastate.cpre388.homework2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;

// make ColorActivity implement INumberChosenWatcher.
public class ColorActivity extends AppCompatActivity implements INumberChosenWatcher{
    /** The instance of the root ViewGroup of the layout. */
    ViewGroup colorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        // Locate the instance of the root ViewGroup
        colorLayout = findViewById(R.id.colorLayout);
        // Set an initial color value.
        setColorByNumber(0);
    }

    /**
     * Helper function to set the color based on a number.
     * @param val a number 0..10.
     */
    private void setColorByNumber(int val) {
        // Scale the 0..10 number to a 0..255 number.
        int scaledVal = val * 255 / 10;
        // Keep the value in [0..255]
        scaledVal = Math.max(0, Math.min(255, scaledVal));
        // Create a shade of green based on val.
        int c = Color.rgb(0, scaledVal, 0);
        // Set the color of the layout.
        colorLayout.setBackgroundColor(c);
    }

    // @Override your number chosen callback and give the number value to setColorByNumber().
    @Override
    public void numberChosen(int chosenNumber) {
        setColorByNumber(chosenNumber);
    }
}
