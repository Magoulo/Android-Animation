package com.example.android_animation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


// This is where the android animation will be y'all
class MainActivity : AppCompatActivity() {
    private lateinit var apiAnimationBtn: Button
    private lateinit var customAnimationBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiAnimationBtn = findViewById(R.id.apiAnimationBtn)
        customAnimationBtn = findViewById(R.id.customAnimationBtn)

        apiAnimationBtn.setOnClickListener{
            startActivity(
                Intent(this,
                    ApiAnimationActivity::class.java)
            )
        }

        customAnimationBtn.setOnClickListener{
            startActivity(
                Intent(this,
                    CustomAnimationActivity::class.java)
            )
        }
    }
}