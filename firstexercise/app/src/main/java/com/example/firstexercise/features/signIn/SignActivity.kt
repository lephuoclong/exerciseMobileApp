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
import com.example.firstexercise.features.onboardings.OnboardOneActivity

class SignActivity : AppCompatActivity() {
    private var editTextFullname :EditText?=null
    private var editTextEmail :EditText?=null
    private var editTextPassword :EditText?=null
    private var imageViewVisible:ImageView?=null
    private var btnSignUp:Button?=null
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
            goToHomeActivity()
        }
    }

    private fun goToHomeActivity(){
        val fullname = editTextFullname?.text.toString().trim()
        val email = editTextEmail?.text.toString().trim()
        val password = editTextPassword?.text.toString().trim()
        if(fullname.isEmpty() || email.isEmpty() || password.isEmpty()){
            Toast.makeText(this@SignActivity, "Sign up error !", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this@SignActivity, "Sign up success !", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@SignActivity, OnboardOneActivity::class.java)
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
    }
}