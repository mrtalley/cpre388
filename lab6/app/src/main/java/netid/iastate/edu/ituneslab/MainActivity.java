package netid.iastate.edu.ituneslab;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;

import org.json.JSONArray;
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
        String artistQuery = parseArtist(artistName);

        String url = "https://itunes.apple.com/search?term=" + artistQuery + "&entity=song&limit=20";

        // execute a new DownloadURLTask
        DownloadURLTask task = new DownloadURLTask(this);
        task.execute(url);
    }

    private String parseArtist(String artist) {
        String artistName[] = artist.split(" ");
        String artistQuery = "";

        for(int i = 0; i < artistName.length; i++) {
            if(i != artistName.length - 1) {
                artistQuery += artistName[i] + "+";
            } else {
                artistQuery += artistName[i];
            }
        }

        return artistQuery;
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
        JSONObject songObj = null;
        JSONArray songArray = null;
        ItunesAdapter adapt = null;
        songs.clear();

        try {
            songObj = new JSONObject(result);
            String songResults = songObj.get("results").toString();

            songArray = new JSONArray(songResults);

            for(int i = 0; i < songArray.length(); i++) {
                JSONObject song = songArray.getJSONObject(i);

                String title = song.getString("trackName");
                String album = song.getString("collectionName");

                songs.add(new ItunesSongRecord(album, title));
            }
        } catch(JSONException e) {
            e.printStackTrace();
        }

        adapt = new ItunesAdapter(this, R.layout.rows, songs);
        setListAdapter(adapt);
    }

    public void onSongClicked(View v) {
        WebView wv = findViewById(R.id.webView);

        wv.setWebViewClient(new MyBrowser());
    }
}
