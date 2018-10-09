package edu.iastate.cpre388.homework2;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

// TODO make MainActivity implement INumberChosenWatcher.
public class MainActivity extends AppCompatActivity implements INumberChosenWatcher {
    private FragmentManager fragmentManager;
    private TextView callbackTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        callbackTextView = findViewById(R.id.callbackTextView);
    }

    public void onGotoColorButtonClick(View v) {
        Intent explicitIntent = new Intent(this, ColorActivity.class);
        startActivity(explicitIntent);
    }

    public void onButtonBasicClick(View v) {
        // Load the basic number chooser fragment
        setNumberChooserFragment(new BasicNumberFragment());
    }

    public void onButtonSliderClick(View v) {
        // Load the slider number chooser fragment
        setNumberChooserFragment(new SliderNumberFragment());
    }

    public void onButtonYoursClick(View v) {
        // TODO (extra credit) instantiate your number chooser and put it in the fragment container
    }

    /**
     * Helper function for setting the fragment in the fragmentContainer.
     * @param f the instance of the fragment to put in the container
     */
    private void setNumberChooserFragment(Fragment f) {
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, f)
                .commit();
    }

    /**
     * A helper function intended to be called from a callback function with a received value.
     * NOTE: this function is not intended to be a callback.
     * @param valFromCallback the value send to the callback to be displayed.
     */
    private void showNumberFromCallback(int valFromCallback) {
        // Format the integer into the message format string: "Number from callback: %d"
        String message = getString(R.string.textview_callback_num_format, valFromCallback);
        // Update the UI with the string.
        callbackTextView.setText(message);
    }

    // @Override your number chooser watcher function defined in the interface and call
    // showNumberFromCallback() with the value received from the callback.
    @Override
    public void numberChosen(int chosenNumber) {
        showNumberFromCallback(chosenNumber);
    }
}
