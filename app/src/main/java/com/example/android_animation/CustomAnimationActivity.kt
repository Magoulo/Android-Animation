package com.example.android_animation
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.android_animation.R

class CustomAnimationActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var startCustomAnimationBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_animation)

        imageView = findViewById(R.id.imageViewCustomAnimation)
        startCustomAnimationBtn = findViewById(R.id.customAnimationStartBtn)

        startCustomAnimationBtn.setOnClickListener {
            startAnimation()
        }
    }

    private fun startAnimation() {
        val animation = AnimationUtils.loadAnimation(this, R.anim.tweenanimation)
        imageView.startAnimation(animation)

        // Start the color change animation
        val colorAnimation = imageView.drawable as AnimationDrawable
        imageView.setImageDrawable(colorAnimation)
        colorAnimation.start()
    }
}
