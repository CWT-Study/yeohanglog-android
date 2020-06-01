package team.triplog.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.kakao.auth.AuthType;
import com.kakao.auth.Session;

import team.triplog.KakaoSessionCallback;
import team.triplog.R;

public class SignInActivity extends AppCompatActivity {
    private Session session;
    private ConstraintLayout buttonKakao;
    private KakaoSessionCallback sessionCallback = new KakaoSessionCallback();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        session.removeCallback(sessionCallback);
    }

    private void init() {
        buttonKakao = findViewById(R.id.button_sign_in_kakao_talk);

        session = Session.getCurrentSession();
        session.addCallback(sessionCallback);

        buttonKakao.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button_sign_in_kakao_talk:
                    session.open(AuthType.KAKAO_LOGIN_ALL, SignInActivity.this);
                    break;
            }
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data)) {
            return;
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
