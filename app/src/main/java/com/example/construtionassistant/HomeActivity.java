package com.example.construtionassistant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private String[] imageUrls = {
            "https://www.plantuml.com/plantuml/png/VPHFKzmm3CNl_XGgTuRx7ZhyMGxCG4lPmjtDAei7nqfj6RhVlavY8Cee79Xb_7wMd_pad2UsaNFdpJT-nWwXzzO5Onkc28y9e-cBxXhNsy1mSaT_d4UuwFiJi6dubVgbRLumx65tJ8pToDGboTtGRzXXI1G7fluhaH_4hdMDPKTXNc--RinW4Kw_3qusyBF7C7egVyDYFNe33_WtOs9u8EfWnvPpCbKiN3r-0xyongE09WLEPJ7ECUYrgfEXubuGPNLK1xyRsBhKUokFCjGpF3bycrQtoDRvP014Yngmsgt4T9CBIFKfeR9hCdjBpSlPO_3bPoGMNZLTMfqi2EwAkiwM0m2KVAx_OPCPPv2MJrNVwRtIUc52ws8t3T6owzqplKdYe-NBI6y9uVeL0o-paU9wBXC0joxnQYe2qJCPaLaQ3tWeE4PeAKxYmfz6w8bKCexDlziMaOXNMARIUhUtZ6AZ0K69a0HOjtyTbTYXHYO89RywAtCNMsHi6BP4SVnud5rvIcXM-goNS-4nifaBdsRlSteMU_I7NskCkTrJOhW8WN9ei5DYKm0zDSbyFVH0xLZOXOD-cLLSUGUF_HZtVQJMULmwNggwtIfNMeoPC3uRhvlGqkUhjPxBokiWBXIre-iOAS8TfcGFWodq2U59sIqSQ1t1BZSDfjHcxuzhnrLcVc3OJpUu-4eUABFHhgXg7rUpj5NrcHsZ6AcG2FAybCcT_my0",
            "https://example.com/image2.jpg",
            "https://example.com/image3.jpg",
            "https://example.com/image4.jpg",
            "https://example.com/image5.jpg",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ImageAdapter imageAdapter = new ImageAdapter(this, imageUrls);
        recyclerView.setAdapter(imageAdapter);

        Button navigateToProjectPlanButton = findViewById(R.id.navigate_to_project_plan_button);
        navigateToProjectPlanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, HouseSpecificationActivity.class);
                startActivity(intent);
            }
        });
    }
}
