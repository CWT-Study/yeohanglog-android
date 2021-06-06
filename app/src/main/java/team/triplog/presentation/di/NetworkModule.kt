package team.triplog.presentation.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * @author mjkim
 * @since 2021/06/06
 **/
const val DI_RETROFIT_NO_AUTH = "DI_RETROFIT_NO_AUTH"
const val DI_RETROFIT_NO_AUTH_CLIENT = "DI_RETROFIT_NO_AUTH_CLIENT"
const val SERVER_URL = "http://210.102.178.24:5000/tr"
const val TIME_OUT = 15L

val networkModule = module {
    single { RxJava2CallAdapterFactory.create() as CallAdapter.Factory }
    single { GsonConverterFactory.create() as Converter.Factory }

    single(named(DI_RETROFIT_NO_AUTH)) {
        Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addCallAdapterFactory(get())
            .addConverterFactory(get())
            .client(get(named(DI_RETROFIT_NO_AUTH_CLIENT)))
            .build()
    }

    single(named(DI_RETROFIT_NO_AUTH_CLIENT)) {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor())
            .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
            .build()
    }
}
