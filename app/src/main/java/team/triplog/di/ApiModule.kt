package team.triplog.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import team.triplog.data.source.remote.api.TripApi
import team.triplog.data.source.remote.api.UserApi


/**
 * Created by Minjae Kim on 2020.12.20.
 *
 * DESC : 서버 Api DI
 */
val apiModule = module {
    single { (get(named(DI_RETROFIT_NO_AUTH)) as Retrofit).create(UserApi::class.java) }
    single { (get(named(DI_RETROFIT_NO_AUTH)) as Retrofit).create(TripApi::class.java) }
}
