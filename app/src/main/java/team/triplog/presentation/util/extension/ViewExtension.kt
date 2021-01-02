package team.triplog.presentation.util.extension

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.view.MotionEvent
import android.view.View


/**
 * Created by Minjae Kim on 2021.01.02.
 */

@SuppressLint("ClickableViewAccessibility")
fun View.setupButton() {
    this.setOnTouchListener { _, event ->
        when (event.action) {
            MotionEvent.ACTION_UP,
            MotionEvent.ACTION_CANCEL -> this.setClickAnimation(false)
            MotionEvent.ACTION_DOWN -> this.setClickAnimation(true)
        }
        false
    }
}

fun View.setClickAnimation(isDown: Boolean) {
    val value = if (isDown) 0.98F else 1F
    val x = ObjectAnimator.ofFloat(this, "scaleX", value).apply { duration = 50L }
    val y = ObjectAnimator.ofFloat(this, "scaleY", value).apply { duration = 50L }
    AnimatorSet().let { set ->
        set.play(x).with(y)
        set.start()
    }
}