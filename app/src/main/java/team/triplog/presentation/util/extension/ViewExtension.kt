package team.triplog.presentation.util.extension

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager


/**
 * @author mjkim
 * @since 2021.01.02
 */

@SuppressLint("ClickableViewAccessibility")
fun View.setupButton(clickSize: Float = 0.98F) {
    this.setOnTouchListener { _, event ->
        when (event.action) {
            MotionEvent.ACTION_UP,
            MotionEvent.ACTION_CANCEL -> this.setClickAnimation(false, clickSize)
            MotionEvent.ACTION_DOWN -> this.setClickAnimation(true, clickSize)
        }
        false
    }
}

@SuppressLint("Recycle")
fun View.setClickAnimation(isDown: Boolean, clickSize: Float) {
    val value = if (isDown) clickSize else 1F
    val x = ObjectAnimator.ofFloat(this, "scaleX", value).apply { duration = 50L }
    val y = ObjectAnimator.ofFloat(this, "scaleY", value).apply { duration = 50L }
    AnimatorSet().let { set ->
        set.play(x).with(y)
        set.start()
    }
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
    this.clearFocus()
}

fun View.showKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, InputMethodManager.HIDE_IMPLICIT_ONLY)
    this.requestFocus()
}