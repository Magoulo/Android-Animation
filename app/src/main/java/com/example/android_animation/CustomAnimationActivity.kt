package com.example.android_animation

import android.animation.*
import android.annotation.SuppressLint
import android.graphics.PorterDuff
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd
import androidx.core.content.ContextCompat
import com.example.android_animation.R

class CustomAnimationActivity : AppCompatActivity() {

    private lateinit var imageViewRectangle: ImageView
    private lateinit var imageViewBlackLine: ImageView
    private lateinit var startCustomAnimationBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_animation)

        imageViewRectangle = findViewById(R.id.imageViewCustomAnimation)
        imageViewBlackLine = findViewById(R.id.imageView)
        startCustomAnimationBtn = findViewById(R.id.customAnimationStartBtn)

        startCustomAnimationBtn.setOnClickListener {

                startAnimation()

        }
    }

    private fun startAnimation() {

        // The Box position and scaling animation
        val customAnimation = AnimationUtils.loadAnimation(this, R.anim.tweenanimation)
        var repeatCounter = 0
        val maxRepeats = 28 // looping 15 times

        customAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
            }

            override fun onAnimationEnd(animation: Animation) {
                // Increment the counter and restart the animation
                if (repeatCounter < maxRepeats) {

                    println("repeatCounter: $repeatCounter")
                    imageViewRectangle.startAnimation(customAnimation)
                }
                repeatCounter += 1
            }

            override fun onAnimationRepeat(animation: Animation) {
            }
        })
        imageViewRectangle.startAnimation(customAnimation)

        // The color animation
        val colors = intArrayOf(
            ContextCompat.getColor(this, R.color.blue),
            ContextCompat.getColor(this, R.color.purple),
            ContextCompat.getColor(this, R.color.fuchsia),
            ContextCompat.getColor(this, R.color.yellow),
            ContextCompat.getColor(this, R.color.green)
        )
        val colorAnimator = ValueAnimator.ofArgb(*colors)
        colorAnimator.repeatCount = 14 // looping 5 times
        colorAnimator.repeatMode = ValueAnimator.RESTART
        colorAnimator.duration = 4000 // 4 seconds
        colorAnimator.addUpdateListener {
            val color = it.animatedValue as Int
            imageViewRectangle.setColorFilter(color)
        }
        colorAnimator.start()

        // The opacity animation for the black line
        val animator1 = ValueAnimator.ofFloat(0.0f, 0.0f)
        animator1.duration = 960 // 24% of 4 seconds
        val animator2 = ValueAnimator.ofFloat(0.0f, 1.0f)
        animator2.duration = 200 // 5% of 4 seconds
        val animator3 = ValueAnimator.ofFloat(1.0f, 0.0f)
        animator3.duration = 200 // 5% of 4 seconds
        val animator4 = ValueAnimator.ofFloat(0.0f, 0.0f)
        animator4.duration = 1680 // 42% of 4 seconds
        val animator5 = ValueAnimator.ofFloat(0.0f, 1.0f)
        animator5.duration = 200 // 5% of 4 seconds
        val animator6 = ValueAnimator.ofFloat(1.0f, 1.0f)
        animator6.duration = 800 // 20% of 4 seconds

        animator1.addUpdateListener {
            val alpha = it.animatedValue as Float
            imageViewBlackLine.alpha = alpha
        }
        animator2.addUpdateListener {
            val alpha = it.animatedValue as Float
            imageViewBlackLine.alpha = alpha
        }
        animator3.addUpdateListener {
            val alpha = it.animatedValue as Float
            imageViewBlackLine.alpha = alpha
        }
        animator4.addUpdateListener {
            val alpha = it.animatedValue as Float
            imageViewBlackLine.alpha = alpha
        }
        animator5.addUpdateListener {
            val alpha = it.animatedValue as Float
            imageViewBlackLine.alpha = alpha
        }
        animator6.addUpdateListener {
            val alpha = it.animatedValue as Float
            imageViewBlackLine.alpha = alpha
        }

        val blackLineAnimatorSet = AnimatorSet()
        val animationsList = mutableListOf<Animator>()

        for (i in 0 until 15) {
            animationsList.add(animator1.clone())
            animationsList.add(animator2.clone())
            animationsList.add(animator3.clone())
            animationsList.add(animator4.clone())
            animationsList.add(animator5.clone())
            animationsList.add(animator6.clone())
        }

        blackLineAnimatorSet.playSequentially(animationsList) // animator7
        blackLineAnimatorSet.start()
    }
}
