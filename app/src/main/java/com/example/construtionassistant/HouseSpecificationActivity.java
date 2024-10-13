package com.example.construtionassistant;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class HouseSpecificationActivity extends AppCompatActivity {

    private EditText landAreaEditText, numberOfFloorsEditText, numberOfRoomsEditText;
    private Spinner houseDesignSpinner;
    private Button generateButton, contractorDetailsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_specification);

        landAreaEditText = findViewById(R.id.landAreaEditText);
        numberOfFloorsEditText = findViewById(R.id.numberOfFloorsEditText);
        numberOfRoomsEditText = findViewById(R.id.numberOfRoomsEditText);
        houseDesignSpinner = findViewById(R.id.houseDesignSpinner);
        generateButton = findViewById(R.id.generateButton);
        contractorDetailsButton = findViewById(R.id.contractorDetailsButton);

        // Set up the spinner with house design options
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.house_designs, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        houseDesignSpinner.setAdapter(adapter);

        // Set onClick listeners for buttons
        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the generation of the house plan
            }
        });

        contractorDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle contractor details
            }
        });
    }
}
