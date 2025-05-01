package com.example.uts

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "SplashActivity"
        private const val SPLASH_DURATION = 3000L // 3 detik
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreenactivity)

        Log.d(TAG, "SplashScreen started")

        // Handler untuk menunda perpindahan ke LoginActivity
        Handler(Looper.getMainLooper()).postDelayed({
            // Intent untuk pindah ke LoginActivity
            val intent = Intent(this@SplashActivity, LoginActivity::class.java)
            startActivity(intent)
            finish() // Tutup SplashActivity agar tidak bisa kembali dengan tombol back

            Log.d(TAG, "Moving to LoginActivity")
        }, SPLASH_DURATION)
    }
}
