package com.example.firstexercise.features.verificationCode

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.firstexercise.R
import com.example.firstexercise.features.login.LoginActivity
import com.example.firstexercise.features.onboardings.OnboardOneActivity
import com.wynsbin.vciv.VerificationCodeInputView
import com.wynsbin.vciv.VerificationCodeInputView.OnInputListener


class VerifyActivity : AppCompatActivity() {

    private var imgBtnComeback:ImageView?=null
    private var vciv_code1:VerificationCodeInputView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        setContentView(R.layout.activity_verify)

        initializeWidget()

        imgBtnComeback?.setOnClickListener {
            onClickGoBack()
        }

        vciv_code1?.setOnInputListener(object : OnInputListener {
            override fun onComplete(code: String) {
                if(code =="1234"){
                    var intent = Intent(this@VerifyActivity, OnboardOneActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this@VerifyActivity, "Verify code failed", Toast.LENGTH_SHORT)
                }
            }

            override fun onInput() {}
        })
    }

    private fun onClickGoBack() {
        val intent = Intent(this@VerifyActivity, LoginActivity::class.java)
        this.finish()
        startActivity(intent)
    }

    private fun initializeWidget() {
        imgBtnComeback = findViewById(R.id.imgBtnComeback)
        vciv_code1 = findViewById(R.id.vciv_code1)
    }
}