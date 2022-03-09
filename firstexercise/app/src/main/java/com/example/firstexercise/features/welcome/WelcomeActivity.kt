package com.example.firstexercise.features.welcome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstexercise.R

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
    }
//    click to login -> redirect to LoginLayout
//    click to signin -> redirect to SigninLayout
}