package com.example.android_animation

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
            imageView.setColorFilter(color)
        }
        animator.start()
    }




}
