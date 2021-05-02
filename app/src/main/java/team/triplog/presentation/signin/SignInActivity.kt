package team.triplog.presentation.signin

import android.content.Intent
import com.kakao.auth.AuthType
import com.kakao.auth.ISessionCallback
import com.kakao.auth.Session
import com.kakao.network.ErrorResult
import com.kakao.usermgmt.UserManagement
import com.kakao.usermgmt.callback.MeV2ResponseCallback
import com.kakao.usermgmt.response.MeV2Response
import com.kakao.util.OptionalBoolean
import com.kakao.util.exception.KakaoException
import team.triplog.R
import team.triplog.databinding.ActivitySignInBinding
import team.triplog.presentation.base.BaseActivity
import team.triplog.presentation.main.MainActivity
import timber.log.Timber


/**
 * @author  mjkim
 * @version 1.0.0
 * @since   2021.05.02
 */
class SignInActivity : BaseActivity<ActivitySignInBinding>(R.layout.activity_sign_in) {

    private var session: Session? = null

    override fun setup() {
        init()
        setupViewModel()
    }

    override fun onDestroy() {
        super.onDestroy()
        session?.removeCallback(sessionCallback)
    }

    private fun init() {
        session = Session.getCurrentSession()
        session?.addCallback(sessionCallback)

        binding.viewSignInKakao.setOnClickListener {
            session?.open(AuthType.KAKAO_LOGIN_ALL, this@SignInActivity)
        }
    }

    private fun setupViewModel() {
        // TODO
    }

    private fun getUser() {
        UserManagement.getInstance()
            .me(object : MeV2ResponseCallback() {
                override fun onSessionClosed(errorResult: ErrorResult) {
                    Timber.e("세션이 닫혀 있음: $errorResult")
                }

                override fun onFailure(errorResult: ErrorResult) {
                    Timber.e("사용자 정보 요청 실패: $errorResult")
                }

                override fun onSuccess(result: MeV2Response) {
                    Timber.i("사용자 아이디: ${result.id}")
                    val kakaoAccount = result.kakaoAccount
                    if (kakaoAccount != null) {

                        // 이메일
                        val email = kakaoAccount.email
                        Timber.i("email: $email")
                        when (OptionalBoolean.TRUE) {
                            kakaoAccount.emailNeedsAgreement() -> {
                                // 동의 요청 후 이메일 획득 가능
                                // 단, 선택 동의로 설정되어 있다면 서비스 이용 시나리오 상에서 반드시 필요한 경우에만 요청해야 합니다.
                            }
                            else -> {
                                // 이메일 획득 불가
                            }
                        }

                        // 프로필
                        val profile = kakaoAccount.profile
                        when {
                            profile != null -> {
                                // TODO : Room 으로 변경하기 위해 주석처리
                                callActivity()
                            }
                            kakaoAccount.profileNeedsAgreement() == OptionalBoolean.TRUE -> {
                                // 동의 요청 후 프로필 정보 획득 가능
                            }
                            else -> {
                                // 프로필 획득 불가
                            }
                        }
                    }
                }
            })
    }

    private fun callActivity() {
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private val sessionCallback: ISessionCallback = object : ISessionCallback {
        override fun onSessionOpened() {
            Timber.i("onSessionOpened : ")
            getUser()
        }

        override fun onSessionOpenFailed(exception: KakaoException) {
            Timber.e(exception, "onSessionOpenFailed : ")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data)) {
            return
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}