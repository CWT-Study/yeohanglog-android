package team.triplog.presentation.util

import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.TextView
import java.text.DecimalFormat


/**
 * @author  mjkim
 * @since   2021.05.02
 */
class TextCountAnimation(var textView: TextView, var to: Int) : Animation() {
    var from = 0
    var integerCommaFormat = DecimalFormat("###,###")

    public override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
        super.applyTransformation(interpolatedTime, t)
        duration = 1000
        textView.text = integerCommaFormat.format(
            (from + (to - from) * interpolatedTime.toDouble())
        )
    }
}