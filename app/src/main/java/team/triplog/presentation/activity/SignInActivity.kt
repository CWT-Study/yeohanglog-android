package team.triplog.presentation.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.kakao.auth.AuthType
import com.kakao.auth.ISessionCallback
import com.kakao.auth.Session
import com.kakao.network.ErrorResult
import com.kakao.usermgmt.UserManagement
import com.kakao.usermgmt.callback.MeV2ResponseCallback
import com.kakao.usermgmt.response.MeV2Response
import com.kakao.util.OptionalBoolean
import com.kakao.util.exception.KakaoException
import kotlinx.android.synthetic.main.activity_sign_in.*
import team.triplog.R
import team.triplog.data.local.User
import team.triplog.presentation.base.BaseActivity

class SignInActivity : BaseActivity() {
    private var session: Session? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        init()
    }

    override fun onDestroy() {
        super.onDestroy()
        session?.removeCallback(sessionCallback)
    }

    private fun init() {
        session = Session.getCurrentSession()
        session?.addCallback(sessionCallback)

        view_sign_in_kakao.setOnClickListener(onClickListener)
    }

    private fun getUser() {
        UserManagement.getInstance()
            .me(object : MeV2ResponseCallback() {
                override fun onSessionClosed(errorResult: ErrorResult) {
                    Log.e("::::: KAKAO_API", "세션이 닫혀 있음: $errorResult")
                }

                override fun onFailure(errorResult: ErrorResult) {
                    Log.e("::::: KAKAO_API", "사용자 정보 요청 실패: $errorResult")
                }

                override fun onSuccess(result: MeV2Response) {
                    Log.i("::::: KAKAO_API", "사용자 아이디: " + result.id)
                    val kakaoAccount = result.kakaoAccount
                    if (kakaoAccount != null) {

                        // 이메일
                        val email = kakaoAccount.email
                        Log.i("::::: KAKAO_API", "email: $email")
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
                                realm?.executeTransaction {
                                    val user = User()
                                    user.apply {
                                        id = result.id.toInt()
                                        name = profile.nickname
                                        image = profile.profileImageUrl
                                    }

                                    it.insertOrUpdate(user)
                                    it.commitTransaction()
                                }
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
            Log.i("::::: KAKAO_SESSION", "onSessionOpened : ")
            getUser()
        }

        override fun onSessionOpenFailed(exception: KakaoException) {
            Log.e("::::: KAKAO_SESSION", "onSessionOpenFailed : ", exception)
        }
    }
    private val onClickListener = View.OnClickListener { view ->
        when (view.id) {
            R.id.view_sign_in_kakao -> {
                session?.open(AuthType.KAKAO_LOGIN_ALL, this@SignInActivity)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data)) {
            return
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}