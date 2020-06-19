package team.triplog.presentation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import androidx.appcompat.app.AppCompatActivity;

import com.kakao.auth.Session;

import team.triplog.R;

public class SplashActivity extends AppCompatActivity {
    long DURATION = 2500L;
    boolean session = false;
    View viewLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        init();
    }

    private void init() {
        viewLogo = findViewById(R.id.view_logo);
        session = Session.getCurrentSession().checkAndImplicitOpen();
        setAnimation();
    }

    private void setAnimation() {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(DURATION);
        anim.setStartOffset(0);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.ABSOLUTE);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent;

                if (session) {
                    intent = new Intent(getApplicationContext(), MainActivity.class);
                    // TODO : User 정보 가져오기
                } else {
                    intent = new Intent(getApplicationContext(), SignInActivity.class);
                }

                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

        viewLogo.startAnimation(anim);
    }
}
