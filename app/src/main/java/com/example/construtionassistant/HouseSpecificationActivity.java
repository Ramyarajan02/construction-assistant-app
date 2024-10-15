package com.example.construtionassistant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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
                generateHousePlan();
            }
        });

        contractorDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToContractorDetails();
            }
        });
    }

    private void generateHousePlan() {
        // Retrieve input values
        String landArea = landAreaEditText.getText().toString();
        String numberOfFloors = numberOfFloorsEditText.getText().toString();
        String numberOfRooms = numberOfRoomsEditText.getText().toString();
        String houseDesign = houseDesignSpinner.getSelectedItem().toString();

        // Validate input (simple example)
        if (landArea.isEmpty() || numberOfFloors.isEmpty() || numberOfRooms.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Proceed to the next activity with the provided specifications
        Intent intent = new Intent(HouseSpecificationActivity.this, ConstructionMaterialsActivity.class);
        intent.putExtra("landArea", landArea);
        intent.putExtra("numberOfFloors", numberOfFloors);
        intent.putExtra("numberOfRooms", numberOfRooms);
        intent.putExtra("houseDesign", houseDesign);
        startActivity(intent);
    }

    private void navigateToContractorDetails() {
        // Navigate to the Contractor Selection activity
        Intent intent = new Intent(HouseSpecificationActivity.this, ContractorSelectionActivity.class);
        startActivity(intent);
    }
}
