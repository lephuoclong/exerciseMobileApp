package com.example.firstexercise

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.Window
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.firstexercise.features.welcome.WelcomeActivity

class MainActivity : AppCompatActivity() {

    private var progressBar: ProgressBar? = null
    private var i = 0
    private var handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        supportActionBar?.hide();
        setContentView(R.layout.activity_main)
        progressBar = findViewById<ProgressBar>(R.id.loadingIntoApp) as ProgressBar
        progressBar!!.visibility =View.VISIBLE;
        progressBar!!.max = 100;
        i = progressBar!!.progress;

        Thread(Runnable {

            while (i < 100) {
                i += 1
                handler.post(Runnable {
                    progressBar!!.progress=i;
                })
                try {
                    Thread.sleep(100)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }

            progressBar!!.visibility = View.INVISIBLE

            val intent = Intent(this, WelcomeActivity::class.java);
            startActivity(intent)
        }).start()

    }
}