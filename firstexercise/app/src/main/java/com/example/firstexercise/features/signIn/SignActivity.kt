package com.example.firstexercise.features.signIn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.firstexercise.R
import com.example.firstexercise.features.login.LoginActivity
import com.example.firstexercise.features.onboardings.OnboardOneActivity
import com.example.firstexercise.features.verificationCode.VerifyActivity

class SignActivity : AppCompatActivity() {
    private var editTextFullname :EditText?=null
    private var editTextEmail :EditText?=null
    private var editTextPassword :EditText?=null
    private var imageViewVisible:ImageView?=null
    private var btnSignUp:Button?=null
    private var btnComeBackWelcome:Button?=null
    private var showPass = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        setContentView(R.layout.activity_sign)

        initializeWidget()

        imageViewVisible?.setOnClickListener {
            onClickShowPass()
        }

        btnSignUp?.setOnClickListener {
            goToVerifyActivity()
        }

        btnComeBackWelcome?.setOnClickListener {
            finishActivity()
        }
    }

    private fun finishActivity() {
        var intent = Intent(this@SignActivity, LoginActivity::class.java)
        this.finish();
        startActivity(intent);
    }

    private fun goToVerifyActivity(){
        val fullName = editTextFullname?.text.toString().trim() == "exitsUser"
        val email = editTextEmail?.text.toString().trim() == "example@gmail.com"
        val password = editTextPassword?.text.toString().trim() == "123123"

        if (fullName){
            Toast.makeText(this@SignActivity, "Username is exits!", Toast.LENGTH_SHORT).show()
        }

        if (email) {
            Toast.makeText(this@SignActivity, "Email is exits!", Toast.LENGTH_SHORT).show()
        }

        if (password){
            Toast.makeText(this@SignActivity, "You need an other strong password!", Toast.LENGTH_SHORT).show()
        }

        if( !fullName && !email && !password){
            Toast.makeText(this@SignActivity, "Sign up success!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@SignActivity, VerifyActivity::class.java)
            startActivity(intent)

        }


    }
    private fun onClickShowPass() {
        if(showPass){
            showPass=false
            editTextPassword?.transformationMethod=PasswordTransformationMethod.getInstance()
            imageViewVisible?.setImageResource(R.drawable.ic_visibility)
        }else{
            showPass=true
            editTextPassword?.transformationMethod=HideReturnsTransformationMethod.getInstance()
            imageViewVisible?.setImageResource(R.drawable.ic_visibility_off)
        }
    }
    private fun initializeWidget(){
        editTextFullname = findViewById(R.id.editTextFullnameSignup)
        editTextEmail = findViewById(R.id.editTextEmailSignup)
        editTextPassword = findViewById(R.id.editTextPasswordSignUp)
        imageViewVisible = findViewById(R.id.imageViewShowHidePassword)
        btnSignUp = findViewById(R.id.buttonSignUp)
        btnComeBackWelcome = findViewById(R.id.btnComeBackWelcome)
    }
}