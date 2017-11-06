package com.peraktravelguide.puo.peraktravelguide;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by SAFWAN FAIDHI on 20-Jul-17.
 */

public class interestingPlace extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interesting_place);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarPlace);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setSubtitle("Interesting"); // setting a title for this Toolbar
        toolbar.setSubtitleTextColor(Color.WHITE);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public void getMuseum(View view) {
        Intent intent = new Intent(this, GoogleMapApi.class);
        intent.putExtra("query", "historical+in+perak");
        intent.putExtra("type", "Historical");
        startActivity(intent);
    }

    public void getPark(View view) {
        Intent intent = new Intent(this, GoogleMapApi.class);
        intent.putExtra("query", "recreation+park+in+perak");
        intent.putExtra("type", "Recreation Park");
        startActivity(intent);
    }

    public void getNature(View view) {
        Intent intent = new Intent(this, GoogleMapApi.class);
        intent.putExtra("query", "nature+preserve+in+perak");
        intent.putExtra("type", "Nature Preserve");
        startActivity(intent);
    }

    public void getMall(View view) {
        Intent intent = new Intent(this, GoogleMapApi.class);
        intent.putExtra("query", "mall+in+perak");
        intent.putExtra("type", "Shopping Mall");
        startActivity(intent);
    }

    public void getMarket(View view) {
        Intent intent = new Intent(this, GoogleMapApi.class);
        intent.putExtra("query", "pasar+malam+in+perak");
        intent.putExtra("type", "Night Market");
        startActivity(intent);
    }

    public void getWaterfall(View view) {
        Intent intent = new Intent(this, GoogleMapApi.class);
        intent.putExtra("query", "fall+in+perak");
        intent.putExtra("type", "Waterfall");
        startActivity(intent);
    }

    public void showAll(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}