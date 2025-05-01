package com.example.uts

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.uts.R


class LoginActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "LoginActivity"
    }

    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button
    private lateinit var textViewRegister: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Log.d(TAG, "LoginActivity created")

        // Inisialisasi views
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)
        textViewRegister = findViewById(R.id.textViewRegister)

        // Set click listener untuk tombol login
        buttonLogin.setOnClickListener {
            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()

            // Simple validation
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                Log.e(TAG, "Login failed: empty fields")
            } else {
                // For demo purposes, we'll consider any login as successful
                Log.d(TAG, "Login successful for: $email")
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()

                // Navigate to GalleryActivity
                val intent = Intent(this, GalleryAdapter::class.java)
                startActivity(intent)
            }
        }

        // Set click listener untuk text register
        textViewRegister.setOnClickListener {
            Log.d(TAG, "Navigate to RegisterActivity")
            // Navigate to RegisterActivity
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}