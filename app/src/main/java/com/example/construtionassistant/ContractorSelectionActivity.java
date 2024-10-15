package com.example.construtionassistant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ContractorSelectionActivity extends AppCompatActivity {

    private Button basedOnReviewButton, basedOnProfileButton;
    private TextView titleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contractor_selection);

        titleTextView = findViewById(R.id.title);
        basedOnReviewButton = findViewById(R.id.based_on_review);
        basedOnProfileButton = findViewById(R.id.based_on_profile);

        // Set click listeners for buttons
        basedOnReviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle navigation based on review
                Intent intent = new Intent(ContractorSelectionActivity.this, ReviewBasedContractorsActivity.class);
                startActivity(intent);
            }
        });

        basedOnProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle navigation based on profile
                Intent intent = new Intent(ContractorSelectionActivity.this, ProfileBasedContractorsActivity.class);
                startActivity(intent);
            }
        });
    }
}
