package com.peraktravelguide.puo.peraktravelguide;


import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by SAFWAN FAIDHI on 31-Aug-17.
 */

public class GoogleMapApi extends AppCompatActivity {

    private static final String apiKey = "AIzaSyD9iAcTWZ1OK1yMCx2lkvcHEef7ok5vz78";
    ArrayList<HashMap<String, Object>> mapsList;
    private String TAG = GoogleMapApi.class.getSimpleName();
    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maps_list);

        String type = getIntent().getStringExtra("type");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarPlace); // get the reference of Toolbar
        setSupportActionBar(toolbar); // Setting/replace toolbar as the ActionBar4
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setSubtitle(type); // setting a title for this Toolbar
        toolbar.setSubtitleTextColor(Color.WHITE);

        mapsList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.list);

        new GetMaps().execute();

        // get data from ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {

                String query = getIntent().getStringExtra("query");
                String type = getIntent().getStringExtra("type");

                TextView lat = (TextView) view.findViewById(R.id.latitude);
                String latitude = lat.getText().toString();

                TextView lng = (TextView) view.findViewById(R.id.longitude);
                String longitude = lng.getText().toString();

                Intent intent = new Intent(GoogleMapApi.this, MapsActivity.class);
                intent.putExtra("query", query);
                intent.putExtra("latitude", latitude);
                intent.putExtra("longitude", longitude);

                startActivity(intent);
            }
        });
    }

    public void showMaps(View view) {
        String query = getIntent().getStringExtra("query");

        Intent intent = new Intent(GoogleMapApi.this, MapDisplayAll.class);
        intent.putExtra("query", query);
        startActivity(intent);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private class GetMaps extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {

            HttpHandler sh = new HttpHandler();

            String query = getIntent().getStringExtra("query");

            // making request to url and getting response
            String url = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=" +
                    query + "&key=" + apiKey;

            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url : " + jsonStr);

            if (jsonStr != null) {

                try {

                    JSONObject jsonObj = new JSONObject(jsonStr);

                    if (jsonObj.getString("status").equalsIgnoreCase("OK")) {

                        //String pagetoken = jsonObj.getString("next_page_token");
                        // Getting JSON Array node
                        JSONArray results = jsonObj.getJSONArray("results");
                        // Looping through all results
                        for (int i = 0; i < results.length(); i++) {

                            JSONObject data = results.getJSONObject(i);
                            String name = data.getString("name");
                            String address = data.getString("formatted_address");
                            String latitude = data.getJSONObject("geometry").getJSONObject("location")
                                    .getString("lat");
                            String longitude = data.getJSONObject("geometry").getJSONObject("location")
                                    .getString("lng");

                            HashMap<String, Object> result = new HashMap<>();

                            result.put("name", name);
                            result.put("address", address);
                            result.put("lat", latitude);
                            result.put("lng", longitude);

                            mapsList.add(result);
                        }
                    } else {
                        Toast.makeText(GoogleMapApi.this, "Sorry, service unavailable", Toast.LENGTH_SHORT).show();
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    });
                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            final ListAdapter adapter = new SimpleAdapter(GoogleMapApi.this, mapsList, R.layout.list_item
                    , new String[]{"name", "address", "lat", "lng"}, new int[]{R.id.name, R.id.address, R.id.latitude, R.id.longitude});
            listView.setAdapter(adapter);
        }
    }
}
