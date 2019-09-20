package com.example.firebaseauth;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class LocationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] locations;
    String[] supermarkets;
    ListView supermarketslistView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Spinner spin_locations= findViewById(R.id.locations);
        supermarketslistView= findViewById(R.id.list);
        spin_locations.setOnItemSelectedListener(this);

        locations= getResources().getStringArray(R.array.location_arrays);
        ArrayAdapter locations_adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,locations);
        locations_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_locations.setAdapter(locations_adapter);



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        int supermarket = getResources().getIdentifier(locations[position], "array", getPackageName());
        supermarkets = getResources().getStringArray(supermarket);
        ArrayAdapter<String> supermarketsadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, supermarkets);

        supermarketslistView.setAdapter(supermarketsadapter);
        supermarketslistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String  itemValue    = (String) supermarketslistView.getItemAtPosition(position);

                Intent intent= new Intent(getApplicationContext(),CategoriesActivity.class);
                startActivity(intent);

            }
        });



        //Toast.makeText(getApplicationContext(),locations[position] , Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
