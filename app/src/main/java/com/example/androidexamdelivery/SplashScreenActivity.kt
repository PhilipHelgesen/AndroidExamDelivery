package com.example.androidexamdelivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val button = findViewById<Button>(R.id.button1)

        button.setOnClickListener{
            val intent1 = Intent(this, CryptocurrencyMainActivity::class.java)
            startActivity(intent1)
        }
    }
}