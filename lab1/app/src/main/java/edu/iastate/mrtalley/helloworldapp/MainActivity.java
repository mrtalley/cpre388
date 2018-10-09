package edu.iastate.mrtalley.helloworldapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private String[] adventurerNames;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adventurerNames = getResources().getStringArray(R.array.adventurerNames);
        random = new Random();
    }

    public void chooseButtonOnClick(View v) {
        // Locate the Java instance of the TextView
        TextView nameTextView = findViewById(R.id.adventurerName);

        // Choose a string index at random
        int adventurerIndex = random.nextInt(adventurerNames.length);

        // Set the TextView's text to the chosen name
        nameTextView.setText(adventurerNames[adventurerIndex]);
    }
}
