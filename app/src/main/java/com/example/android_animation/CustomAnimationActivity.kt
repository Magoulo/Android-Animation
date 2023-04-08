package com.example.android_animation

import android.animation.AnimatorSet
import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
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
        val animation = AnimationUtils.loadAnimation(this, R.anim.tweenanimation)
        imageViewRectangle.startAnimation(animation)

        val colors = intArrayOf(
            ContextCompat.getColor(this, R.color.blue),
            ContextCompat.getColor(this, R.color.purple),
            ContextCompat.getColor(this, R.color.fuchsia),
            ContextCompat.getColor(this, R.color.yellow),
            ContextCompat.getColor(this, R.color.green)
        )

        val animator = ValueAnimator.ofArgb(*colors)
        animator.repeatCount = ValueAnimator.INFINITE
        animator.repeatMode = ValueAnimator.REVERSE
        animator.duration = 4000 // 4 seconds
        animator.addUpdateListener {
            val color = it.animatedValue as Int
            imageViewRectangle.setColorFilter(color)
        }

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
        // val animator7 = ValueAnimator.ofFloat(0.0f, 0.0f)
        //  animator7.duration = 0

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

        val animatorSet = AnimatorSet()
        animatorSet.playSequentially(
            animator1,
            animator2,
            animator3,
            animator4,
            animator5,
            animator6
        ) // animator7
        animatorSet.start()

        animator.start()
    }


}
