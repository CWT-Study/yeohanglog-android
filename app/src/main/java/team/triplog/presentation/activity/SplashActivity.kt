package team.triplog.presentation.activity

import android.content.Intent
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import androidx.databinding.DataBindingUtil
import com.kakao.auth.Session
import kotlinx.android.synthetic.main.activity_splash.*
import team.triplog.R
import team.triplog.databinding.ActivitySplashBinding

class SplashActivity : BaseActivity() {
    private lateinit var binding: ActivitySplashBinding

    private var session = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        binding.lifecycleOwner = this

        init()
    }

    private fun init() {
        session = Session.getCurrentSession().checkAndImplicitOpen()
        setAnimation()
    }

    private fun setAnimation() {
        AlphaAnimation(0F, 1F).apply {
            duration = DURATION
            startOffset = 0
            repeatMode = Animation.REVERSE
            repeatCount = Animation.ABSOLUTE
            setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationEnd(animation: Animation) {
                    val intent = if (session) {
                        Intent(applicationContext, MainActivity::class.java)
                        // TODO : User 정보 가져오기
                    } else {
                        Intent(applicationContext, SignInActivity::class.java)
                    }
                    startActivity(intent)
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                    finish()
                }

                override fun onAnimationStart(animation: Animation) {}
                override fun onAnimationRepeat(animation: Animation) {}
            })
            view_logo.startAnimation(this)
        }
    }

    companion object {
        private const val DURATION = 2500L
    }
}