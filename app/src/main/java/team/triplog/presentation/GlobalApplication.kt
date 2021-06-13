package team.triplog.presentation

import android.app.Application
import com.kakao.auth.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import team.triplog.presentation.di.*
import timber.log.Timber


/**
 * @author  mjkim
 * @version 1.0.0
 * @since   2021.05.02
 */
class GlobalApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()
        Timber.plant(Timber.DebugTree())
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
}