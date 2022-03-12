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
    private var signIn :TextView? = null
    private var signUpFaceBook :Button? = null
    private var signUpGoogle :Button? = null
    private var signUpEmailOrPhone :Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        supportActionBar?.hide();
        setContentView(R.layout.activity_welcome)

        init()

        underlineSignUp()

        signIn?.setOnClickListener {
            goToLoginActivity()
        }


        signUpFaceBook?.setOnClickListener{
            goToSignUpActivity()
        }

        signUpGoogle?.setOnClickListener{
            goToSignUpActivity()
        }


        signUpEmailOrPhone?.setOnClickListener {
            goToSignUpActivity()
        }
    }

    private fun underlineSignUp(){
        val mSignIn = signIn!!.text
        val uSignIn = SpannableString(mSignIn)
        uSignIn.setSpan(UnderlineSpan(), 0, uSignIn.length, 0 )
        signIn!!.text = uSignIn
    }
    private fun goToLoginActivity(){
        val intentLoginActivity = Intent(this, LoginActivity::class.java)
        startActivity(intentLoginActivity)
    }

    private fun goToSignUpActivity(){
        val intentSignUpActivity = Intent(this, SignActivity::class.java)
        startActivity(intentSignUpActivity)
    }

    private fun init(){
        signIn = findViewById(R.id.welcome_signin)
        signUpFaceBook = findViewById(R.id.welcome_btn_facebook)
        signUpGoogle = findViewById(R.id.welcome_btn_google)
        signUpEmailOrPhone = findViewById(R.id.welcome_startemailphone)

    }
//    click to login -> redirect to LoginLayout
//    click to signin -> redirect to SigninLayout
}