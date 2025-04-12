package com.innovacion.peloterosapp.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View


import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.innovacion.peloterosapp.R

class MainActivity : AppCompatActivity() {

    private lateinit var logo: View
    private lateinit var appName: View
    private lateinit var splashImg: View
    private lateinit var lottieAnimationView: LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logo = findViewById(R.id.logo)
        appName = findViewById(R.id.app_name)
        splashImg = findViewById(R.id.img)
        lottieAnimationView = findViewById(R.id.lottie)

        lottieAnimationView.repeatCount = LottieDrawable.INFINITE
        lottieAnimationView.playAnimation()

        splashImg.animate().translationY(-1600f).setDuration(1000).startDelay = 4000
        logo.animate().translationY(1400f).setDuration(1000).startDelay = 4000
        appName.animate().translationY(1400f).setDuration(1000).startDelay = 4000
        lottieAnimationView.animate().translationY(1400f).setDuration(1000).startDelay = 4000

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000)
    }
}