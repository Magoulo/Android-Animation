package com.example.android_animation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.airbnb.lottie.LottieAnimationView

class CustomAnimationActivity : AppCompatActivity() {

    private lateinit var LottieAnimationView : LottieAnimationView
    private lateinit var startCustomAnimationBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_animation)

        LottieAnimationView = findViewById(R.id.customAnimationView)
        startCustomAnimationBtn = findViewById(R.id.customAnimationStartBtn)

        var isPlaying = false;
        startCustomAnimationBtn.setOnClickListener{

            if(isPlaying){
                LottieAnimationView.pauseAnimation()
                startCustomAnimationBtn.text = "Start"
            } else {
                LottieAnimationView.playAnimation()
                startCustomAnimationBtn.text = "Pause"
            }
            isPlaying = !isPlaying
        }
    }
}