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

public class foodPlace extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_place);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarFood);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setSubtitle("Food"); // setting a title for this Toolbar
        toolbar.setSubtitleTextColor(Color.WHITE);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public void getRestaurant(View view) {
        Intent intent = new Intent(this, GoogleMapApi.class);
        intent.putExtra("query", "restaurant+in+perak");
        intent.putExtra("type", "Restaurant");
        startActivity(intent);
    }

    public void getCafe(View view) {
        Intent intent = new Intent(this, GoogleMapApi.class);
        intent.putExtra("query", "cafe+in+perak");
        intent.putExtra("type", "Cafe");
        startActivity(intent);
    }

    public void getKFC(View view) {
        Intent intent = new Intent(this, GoogleMapApi.class);
        intent.putExtra("query", "kfc+in+perak");
        intent.putExtra("type", "KFC");
        startActivity(intent);
    }

    public void getMCD(View view) {
        Intent intent = new Intent(this, GoogleMapApi.class);
        intent.putExtra("query", "mcd+in+perak");
        intent.putExtra("type", "MCDonald's");
        startActivity(intent);
    }
}
