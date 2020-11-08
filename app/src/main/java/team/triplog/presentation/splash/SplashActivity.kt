package team.triplog.presentation.splash

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import team.triplog.presentation.main.activity.startMainActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler().postDelayed({ moveNext() }, 500)
    }

    private fun moveNext() {
        // TODO : SharedPreference 로 로그인 관리 필요
        // TODO : Login 된 UserId 가 있을 경우, 분기처리 필요
        startMainActivity()
        finish()
    }
}