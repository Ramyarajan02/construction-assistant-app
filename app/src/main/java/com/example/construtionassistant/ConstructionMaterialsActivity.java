package com.example.construtionassistant;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConstructionMaterialsActivity extends AppCompatActivity {

    private TextView materialsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_construction_materials);

        materialsTextView = findViewById(R.id.title);

        // Display construction materials (hardcoded for example)
        String materialsInfo = "Your Construction Materials:\n\n" +
                "Bricks: 5000 units\n" +
                "Cement: 200 Bags\n" +
                "Steel: 1500 kg\n" +
                "Wood: 30 Cubic metres";

        materialsTextView.setText(materialsInfo);
    }
}
