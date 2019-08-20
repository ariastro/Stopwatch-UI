package com.astronout.stopwatchapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var atg: Animation
    private lateinit var btgone: Animation
    private lateinit var btgtwo: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        atg = AnimationUtils.loadAnimation(this, R.anim.atg)
        btgone = AnimationUtils.loadAnimation(this, R.anim.btgone)
        btgtwo = AnimationUtils.loadAnimation(this, R.anim.btgtwo)

        ivSplash.startAnimation(atg)
        tvSplash.startAnimation(btgone)
        tvSubSplash.startAnimation(btgone)
        btnGet.startAnimation(btgtwo)

        btnGet.setOnClickListener{
            var intent = Intent(this, StopWatchActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }

    }
}
