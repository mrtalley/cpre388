package netid.iastate.edu.ituneslab;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends ListActivity implements DownloadURLTask.ResultHandler {
    /**
     * The list of song records from iTunes to display in the ListView.  This acts as the MVC model.
     */
    ArrayList<ItunesSongRecord> songs = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Handles the onClick event of the search button.
     *
     * @param view the search button
     */
    public void searchButtonClicked(View view) {
        // TODO get the artist to search for from the activity_main.xml view

        // TODO execute a new DownloadURLTask
    }

    /**
     * Callback from a DownloadURLTask when the URL has been retrieved.
     *
     * @param result a string containing the contents returned from the URL
     */
    @Override
    public void handleResult(String result) {
        // TODO handle the Result of the DownloadURLTask network call
    }
}
