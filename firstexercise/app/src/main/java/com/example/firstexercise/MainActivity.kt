package com.example.firstexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        this activity will display "SplashLayout" delay 2s then redirect to
//        welcomeLayout
    }
}