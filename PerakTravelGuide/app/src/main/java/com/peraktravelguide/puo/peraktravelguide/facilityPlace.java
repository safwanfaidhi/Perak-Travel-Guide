package com.peraktravelguide.puo.peraktravelguide;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by User on 20-Jul-17.
 */

public class facilityPlace extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.facility_place);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarFacility);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setSubtitle("Facility"); // setting a title for this Toolbar
        toolbar.setSubtitleTextColor(Color.WHITE);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public void getHotel(View view) {
        Intent intent = new Intent(this, GoogleMapApi.class);
        intent.putExtra("query", "hotel+in+perak");
        intent.putExtra("type", "Hotel");
        startActivity(intent);
    }

    public void getHospital(View view) {
        Intent intent = new Intent(this, GoogleMapApi.class);
        intent.putExtra("query", "hospital+in+perak");
        intent.putExtra("type", "Hospital");
        startActivity(intent);
    }

    public void getMart(View view) {
        Intent intent = new Intent(this, GoogleMapApi.class);
        intent.putExtra("query", "mart+in+perak");
        intent.putExtra("type", "Mart");
        startActivity(intent);
    }

    public void getAtm(View view) {
        Intent intent = new Intent(this, GoogleMapApi.class);
        intent.putExtra("query", "atm+in+perak");
        intent.putExtra("type", "ATM");
        startActivity(intent);
    }

    public void getGas(View view) {
        Intent intent = new Intent(this, GoogleMapApi.class);
        intent.putExtra("query", "gas+station+in+perak");
        intent.putExtra("type", "Gas Station");
        startActivity(intent);
    }

    public void getPolice(View view) {
        Intent intent = new Intent(this, GoogleMapApi.class);
        intent.putExtra("query", "police+station+in+perak");
        intent.putExtra("type", "Police Station");
        startActivity(intent);
    }

    public void getWorkshop(View view) {
        Intent intent = new Intent(this, GoogleMapApi.class);
        intent.putExtra("query", "workshop+in+perak");
        intent.putExtra("type", "Workshop");
        startActivity(intent);
    }

    public void getAirport(View view) {
        Intent intent = new Intent(this, GoogleMapApi.class);
        intent.putExtra("query", "airport+in+perak");
        intent.putExtra("type", "Airport");
        startActivity(intent);
    }

    public void getTrain(View view) {
        Intent intent = new Intent(this, GoogleMapApi.class);
        intent.putExtra("query", "train+station+in+perak");
        intent.putExtra("type", "Train Station");
        startActivity(intent);
    }
}
