package netid.iastate.edu.lab5.Activities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import android.annotation.TargetApi;
import android.app.Activity;
import android.arch.persistence.room.Insert;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;


import netid.iastate.edu.agenda.R;
import netid.iastate.edu.lab5.Models.AppDatabase;
import netid.iastate.edu.lab5.Models.Event;

/**
 * This activity is called when the "Add Event" button is pressed on the home page
 * of this app. It pulls in the data from the activity_add_event view and uses the
 * AgendaDataSource class to create the Event object and store its contents in
 * the database.
 */
public class AddEventActivity extends Activity {

    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        database = AppDatabase.getAppDatabase(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_add_event, menu);
        return true;
    }

    /**
     * This is called when the Cancel button is pressed and closes
     * this activity, redirecting the user to the main activity
     * @param view
     */
    public void goBack(View view) {
        Intent homeIntent = new Intent(this, EventListActivity.class);
        startActivity(homeIntent);
    }

    /**
     * This is called when the Add button is pressed. It takes the data that
     * the user entered from the views and sends it to the data source to store
     * in the database. It then redirects the user to the main activity.
     * @param view
     */
    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void addEvent(View view) {

        // Collecting user-entered data from views
        EditText titleText = findViewById(R.id.titleInput);
        EditText locText = findViewById(R.id.locationInput);
        DatePicker startDate = findViewById(R.id.startDateInput);
        TimePicker startTime = findViewById(R.id.startTimeInput);
        DatePicker endDate = findViewById(R.id.endDateInput);
        TimePicker endTime = findViewById(R.id.endTimeInput);
        EditText detailText = findViewById(R.id.detailsInput);

        // create an event object using UI variables above
        String title = titleText.getText().toString();
        String location = locText.getText().toString();
        String startTimeString = formatDateTime(startDate.getMonth(), startDate.getDayOfMonth(), startDate.getYear(), startTime.getHour(), startTime.getMinute());
        String endTimeString = formatDateTime(endDate.getMonth(), endDate.getDayOfMonth(), endDate.getYear(), endTime.getHour(), endTime.getMinute());
        String details = detailText.getText().toString();

        Event newEvent = new Event(title, location, startTimeString, endTimeString, details);

        // insert your newly created event into the database
        database.eventDao().insertEvent(newEvent);



        // Redirect to main activity
        Intent homeIntent = new Intent(this, EventListActivity.class);
        startActivity(homeIntent);

    }


    /*
     * Helper method to format the user input into a readable date and time
     */
    private String formatDateTime(int month, int day, int year, int hour, int minute) {
        Calendar cal = new GregorianCalendar(year, month, day, hour, minute);
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM d, yyyy, 'at' h:mm a", Locale.US);
        return sdf.format(cal.getTime());
    }

}

