package com.example.shadesofred;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;

public class searchDonor extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static final String[] STATES = new String[]{
        "Andhra Pradesh" , "Arunachal Pradesh" , "Assam" , "Bihar" , "Chhattisgarh" , "Delhi", "Goa" , "Gujrat" ,
            "Haryana" , "Maharashtra" , "Tamil Nadu"
    };

    private static final String[] Cities = new String[]{
            "Mumbai" , "Pune" , "Thane" ,"Nagpur" , "Delhi" , "New Delhi" , "Chennai"
    };

    Spinner sp;
    public Button search;
    AutoCompleteTextView state , city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove app bar
        //getSupportActionBar().hide();
        setTitle("Search Donor");
        setContentView(R.layout.activity_search_donor);

        search = (Button) findViewById(R.id.searchbutton);
        state = findViewById(R.id.state);
        city = findViewById(R.id.city);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(searchDonor.this, donarCard.class);
                startActivity(intent);
                finish();
            }
        });

        sp = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.bloodgrp, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(this);

        //state suggestions
        ArrayAdapter <String> adapter1 = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item , STATES);
        state.setAdapter(adapter1);

        //cities suggestions
        ArrayAdapter <String> adapter2 = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item , Cities);
        city.setAdapter(adapter2);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater(); inflater.inflate(R.menu.dmenu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.profile:
                Intent i = new Intent(searchDonor.this,user_info.class);
                startActivity(i);

        }
        return super.onOptionsItemSelected(item);
    }

    public void search(View view) {
    }
}