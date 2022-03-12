package com.example.firstexercise.features.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.firstexercise.R
import com.example.firstexercise.features.onboardings.OnboardOneActivity
import com.example.firstexercise.features.signIn.SignActivity
import com.example.firstexercise.features.verificationCode.VerifyActivity

class LoginActivity : AppCompatActivity() {
    private var btnGoBackWelcome:ImageButton?=null
    private var txtUsername:EditText?=null
    private var txtPassword:EditText?=null
    private var btnLogin:Button?=null
    private var containerLayout: ConstraintLayout?=null
    private var btnGotoSignUp:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        setContentView(R.layout.activity_login)

        initializeWidget()

        btnGoBackWelcome?.setOnClickListener(){
            this.finish()
        }

        btnGotoSignUp?.setOnClickListener{
            var intent = Intent(this@LoginActivity, SignActivity::class.java)
            this.finish()
            startActivity(intent)
        }

        btnLogin?.setOnClickListener(){
            handleLogin()
        }

        containerLayout?.setOnTouchListener { v, event ->
            val imm: InputMethodManager =
                getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
            true
        }

    }

    private fun handleLogin() {
        var username = txtUsername?.text.toString().trim() == "admin"
        var password = txtPassword?.text.toString().trim() == "admin"

        if(username && password) {
            Toast.makeText(this@LoginActivity, "Login Success!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@LoginActivity, OnboardOneActivity::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this@LoginActivity, "Username or password incorrect!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initializeWidget() {
        btnGoBackWelcome = findViewById(R.id.imgBtnComeback)
        txtUsername = findViewById(R.id.txtUsername)
        txtPassword = findViewById(R.id.txtPassword)
        btnLogin = findViewById(R.id.btnLogin)
        btnGotoSignUp = findViewById(R.id.btnGotoSignup)
        containerLayout = findViewById(R.id.containerLayout)
    }
}