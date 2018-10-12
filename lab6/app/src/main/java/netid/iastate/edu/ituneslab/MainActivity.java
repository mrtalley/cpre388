package netid.iastate.edu.ituneslab;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

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
        // get the artist to search for from the activity_main.xml view
        EditText artistField = findViewById(R.id.artistName);
        String artistName = artistField.getText().toString();
        Log.i("ARTIST", artistName);
        String url = "https://itunes.apple.com/search?term=" + artistName + "&entity=song&limit=20";

        // execute a new DownloadURLTask
        DownloadURLTask task = new DownloadURLTask(this);
        task.execute(url);
    }

    /**
     * Callback from a DownloadURLTask when the URL has been retrieved.
     *
     * @param result a string containing the contents returned from the URL
     */
    @Override
    public void handleResult(String result) {
        // TODO handle the Result of the DownloadURLTask network call
        // https://stackoverflow.com/questions/5245840/how-to-convert-jsonstring-to-jsonobject-in-java
        JSONObject obj = null;
        try {
            obj = new JSONObject(result);
            for(int i = 0; i < obj.length(); i++) {
                String album = obj.getString("trackname");
                String title = obj.getString("collectionName");
                songs.add(new ItunesSongRecord(album, title));
            }
        } catch(JSONException e) {
            e.printStackTrace();
        }
    }
}
