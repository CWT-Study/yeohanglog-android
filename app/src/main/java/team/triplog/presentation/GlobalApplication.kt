package team.triplog.presentation

import android.app.Application
import com.kakao.auth.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import team.triplog.presentation.di.*


/**
 * @author  mjkim
 * @version 1.0.0
 * @since   2021.05.02
 */
class GlobalApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        instance = this
        KakaoSDK.init(KakaoSDKAdapter())

        setupKoin()
    }

    override fun onTerminate() {
        super.onTerminate()
        instance = null
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@GlobalApplication)
            modules(
                listOf(
                    apiModule,
                    mainModule,
                    roomModule,
                    dataModule,
                    networkModule,
                    useCaseModule,
                    remoteDataSourceModule,
                    localDataSourceModule,
                    repositoryModule
                )
            )
        }
    }

    class KakaoSDKAdapter : KakaoAdapter() {
        override fun getSessionConfig(): ISessionConfig {
            return object : ISessionConfig {
                override fun getAuthTypes(): Array<AuthType> {
                    return arrayOf(AuthType.KAKAO_LOGIN_ALL)
                }

                override fun isUsingWebviewTimer(): Boolean {
                    return false
                }

                override fun isSecureMode(): Boolean {
                    return false
                }

                override fun getApprovalType(): ApprovalType {
                    return ApprovalType.INDIVIDUAL
                }

                override fun isSaveFormData(): Boolean {
                    return true
                }
            }
        }

        override fun getApplicationConfig(): IApplicationConfig {
            return IApplicationConfig { getInstance()!! }
        }
    }

    companion object {
        private var instance: GlobalApplication? = null
        fun getInstance(): GlobalApplication? {
            checkNotNull(instance) { "This Application does not inherit com.kakao.GlobalApplication" }
            return instance
        }
    }
}