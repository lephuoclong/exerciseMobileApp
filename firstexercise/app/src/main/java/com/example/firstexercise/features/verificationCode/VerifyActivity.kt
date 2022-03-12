package com.example.firstexercise.features.verificationCode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import com.example.firstexercise.R
import com.example.firstexercise.features.login.LoginActivity

class VerifyActivity : AppCompatActivity() {

    private var imgBtnComeback:ImageView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        setContentView(R.layout.activity_verify)

        initializeWidget()

        imgBtnComeback?.setOnClickListener {
            onClickGoBack()
        }
    }

    private fun onClickGoBack() {
        val intent = Intent(this@VerifyActivity, LoginActivity::class.java)
        this.finish()
        startActivity(intent)
    }

    private fun initializeWidget() {
        imgBtnComeback = findViewById(R.id.imgBtnComeback)
    }
}