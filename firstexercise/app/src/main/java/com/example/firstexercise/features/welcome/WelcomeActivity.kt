package com.example.firstexercise.features.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.Window
import android.widget.Button
import android.widget.TextView
import com.example.firstexercise.R
import com.example.firstexercise.features.login.LoginActivity
import com.example.firstexercise.features.signIn.SignActivity

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        supportActionBar?.hide();
        setContentView(R.layout.activity_welcome)
        val signIn  = findViewById<TextView>(R.id.welcome_signin)
        val mSignIn = signIn.text
        val uSignIn = SpannableString(mSignIn)
        uSignIn.setSpan(UnderlineSpan(), 0, uSignIn.length, 0 )
        signIn.text = uSignIn
        signIn.setOnClickListener {
            val intentLoginActivity = Intent(this, LoginActivity::class.java)
            startActivity(intentLoginActivity)
        }


        val signUpFaceBook = findViewById<Button>(R.id.welcome_btn_facebook)
        signUpFaceBook.setOnClickListener{
            val intentSignUpActivity = Intent(this, SignActivity::class.java)
            startActivity(intentSignUpActivity)
        }

        val signUpGoogle = findViewById<Button>(R.id.welcome_btn_google)
        signUpGoogle.setOnClickListener{
            val intentSignUpActivity = Intent(this, SignActivity::class.java)
            startActivity(intentSignUpActivity)
        }

    }
//    click to login -> redirect to LoginLayout
//    click to signin -> redirect to SigninLayout
}