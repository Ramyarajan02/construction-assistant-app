package com.example.construtionassistant

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class StartPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.startpage_activity) // Ensure this layout exists

        // Find the "Get Started" button by its ID
        val getStartedButton: Button = findViewById(R.id.button2)

        // Set an OnClickListener on the button
        getStartedButton.setOnClickListener {
            // Create an Intent to start HomeActivity
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent) // Start the HomeActivity
        }
    }
}
