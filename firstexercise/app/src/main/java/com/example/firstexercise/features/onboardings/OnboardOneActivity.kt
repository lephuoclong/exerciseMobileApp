package com.example.firstexercise.features.onboardings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import com.example.firstexercise.R

class OnboardOneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        setContentView(R.layout.activity_onboard_one)
    }
}