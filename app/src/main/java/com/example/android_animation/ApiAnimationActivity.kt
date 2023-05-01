package com.example.android_animation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.airbnb.lottie.LottieAnimationView

class ApiAnimationActivity : AppCompatActivity() {

    private lateinit var LottieAnimationView : LottieAnimationView
    private lateinit var startApiAnimationBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api_animation)

        LottieAnimationView = findViewById(R.id.apiAnimationView)
        startApiAnimationBtn = findViewById(R.id.apiAnimationStartBtn)

        val repeatCount = 14
        LottieAnimationView.repeatCount = repeatCount

        var isPlaying = false;
        startApiAnimationBtn.setOnClickListener{

            if(isPlaying){
                LottieAnimationView.pauseAnimation()
                startApiAnimationBtn.text = "Start"
            } else {
                LottieAnimationView.playAnimation()
                startApiAnimationBtn.text = "Pause"
            }
            isPlaying = !isPlaying
        }
    }
}