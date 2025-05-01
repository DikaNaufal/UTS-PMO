package com.example.uts

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.uts.LoginActivity
import com.example.uts.R

class RegisterActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "RegisterActivity"
    }

    private lateinit var editTextName: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var editTextConfirmPassword: EditText
    private lateinit var buttonRegister: Button
    private lateinit var textViewLogin: TextView
    private lateinit var imageViewProfile: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        Log.d(TAG, "RegisterActivity created")

        // Inisialisasi views
        editTextName = findViewById(R.id.editTextName)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword)
        buttonRegister = findViewById(R.id.buttonRegister)
        textViewLogin = findViewById(R.id.textViewLogin)
        imageViewProfile = findViewById(R.id.imageViewProfile)

        // Set click listener untuk tombol register
        buttonRegister.setOnClickListener {
            val name = editTextName.text.toString().trim()
            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()
            val confirmPassword = editTextConfirmPassword.text.toString().trim()

            // Menampilkan event Log sesuai ketentuan
            Log.d(TAG, "Register button clicked")
            Log.d(TAG, "Name: $name")
            Log.d(TAG, "Email: $email")

            // Validasi
            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                // Menampilkan Toast sesuai ketentuan
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                Log.e(TAG, "Registration failed: empty fields")
            } else if (password != confirmPassword) {
                // Menampilkan Toast sesuai ketentuan (yang kedua)
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                Log.e(TAG, "Registration failed: passwords do not match")
            } else {
                // Menampilkan Toast ketiga sesuai ketentuan
                Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "Registration successful for: $email")

                // Navigate back to LoginActivity
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        // Set click listener untuk text login
        textViewLogin.setOnClickListener {
            Log.d(TAG, "Navigate back to LoginActivity")
            finish() // Kembali ke LoginActivity
        }
    }
}