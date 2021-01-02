package team.triplog.presentation.base

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.view.MotionEvent
import android.view.View
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {

    @SuppressLint("ClickableViewAccessibility")
    fun setupButton(view: View) {
        view.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> setClickAnimation(view, true)
                MotionEvent.ACTION_UP -> setClickAnimation(view, false)
            }
            false
        }
    }

    /**
     * View 클릭시, 사이즈가 살짝 작아졌다가 다시 커지는 애니메이션 동작
     *  @param isDown   - true  : pressed
     *                  - false : unpressed
     */
    private fun setClickAnimation(view: View, isDown: Boolean) {
        val value = if (isDown) SCALE_DOWN else SCALE_UP
        val x = ObjectAnimator
            .ofFloat(view, "scaleX", value)
            .apply { duration = SCALE_DURATION }
        val y = ObjectAnimator
            .ofFloat(view, "scaleY", value)
            .apply { duration = SCALE_DURATION }
        AnimatorSet().let { set ->
            set.play(x).with(y)
            set.start()
        }
    }

    companion object {
        private const val SCALE_DURATION = 50L
        private const val SCALE_DOWN = 0.98f
        private const val SCALE_UP = 1f
    }
}