package team.triplog.presentation.util;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.TextView;

import java.text.DecimalFormat;

public class TextCountAnimation extends Animation {
    TextView textView;
    int from = 0;
    int to;

    public TextCountAnimation(TextView textView, int to) {
        this.textView = textView;
        this.to = to;
    }

    DecimalFormat integerCommaFormat = new DecimalFormat("###,###");

    @Override
    public void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        setDuration(1000);
        textView.setText(integerCommaFormat.format((int) (from + ((to - from) * (double) interpolatedTime))));
    }
}
