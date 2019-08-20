package com.astronout.stopwatchapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log.d
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_stop_watch.*

class StopWatchActivity : AppCompatActivity() {

    private lateinit var roundingAlone: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stop_watch)

        btnStop.alpha = 0F

        roundingAlone = AnimationUtils.loadAnimation(this, R.anim.roundingalone)

        btnStart.setOnClickListener {
            icAnchor.startAnimation(roundingAlone)
            btnStop.animate().alpha(1F).translationY(-60F).setDuration(300).start()
            btnStart.animate().alpha(0F).setDuration(300).start()
            timer.base = SystemClock.elapsedRealtime()
            timer.start()
            btnStart.isClickable = false
            d("btnStart", "clicked")

        }

        btnStop.setOnClickListener {
            icAnchor.clearAnimation()
            btnStart.animate().alpha(1F).translationY(-0F).setDuration(300).start()
            btnStop.animate().alpha(0F).setDuration(300).start()
            timer.stop()
            btnStart.isClickable = true
            d("btnStop", "clicked")
        }

    }
}
