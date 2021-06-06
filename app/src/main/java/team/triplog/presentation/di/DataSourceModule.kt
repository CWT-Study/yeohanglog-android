package team.triplog.presentation.di

import org.koin.dsl.module
import team.triplog.data.source.local.TripLocalDataSource
import team.triplog.data.source.local.UserLocalDataSource
import team.triplog.data.source.local.impl.TripLocalDataSourceImpl
import team.triplog.data.source.local.impl.UserLocalDataSourceImpl


/**
 * @author mjkim
 * @since 2021/06/06
 **/

val remoteDataSourceModule = module {
}

val localDataSourceModule = module {
    single { UserLocalDataSourceImpl(get()) }
    single { TripLocalDataSourceImpl(get()) }
}

