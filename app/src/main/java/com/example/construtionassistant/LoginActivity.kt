package com.example.construtionassistant

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var etCity: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnGoogleSignIn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        // Initialize UI elements
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        etCity = findViewById(R.id.etCity)
        btnLogin = findViewById(R.id.btnLogin)
        btnGoogleSignIn = findViewById(R.id.btnGoogleSignUp)

        // Set onClickListener for the login button
        btnLogin.setOnClickListener {
            loginUser()
        }

        // Set onClickListener for Google Sign-In button
        btnGoogleSignIn.setOnClickListener {
            // Handle Google Sign-In functionality here
            Toast.makeText(this, "Google Sign-In clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun loginUser() {
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString().trim()
        val city = etCity.text.toString().trim()

        // Simple validation
        if (email.isEmpty() || password.isEmpty() || city.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }

        // Here you can add your login logic (e.g., checking against a database)
        // For demonstration, we will just show a toast and start the next activity
        Toast.makeText(this, "Logging in with $email", Toast.LENGTH_SHORT).show()

        // Start StartPageActivity
        val intent = Intent(this, StartPageActivity::class.java)
        startActivity(intent)
        finish() // Optional: Call finish() if you don't want to return to the login screen
    }

}
