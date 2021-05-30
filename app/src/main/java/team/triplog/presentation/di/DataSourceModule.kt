package team.triplog.presentation.di

import org.koin.dsl.module
import team.triplog.data.source.local.TripLocalDataSource
import team.triplog.data.source.local.UserLocalDataSource
import team.triplog.data.source.local.impl.TripLocalDataSourceImpl
import team.triplog.data.source.local.impl.UserLocalDataSourceImpl


val remoteDataSourceModule = module {
}

val localDataSourceModule = module {
    single { UserLocalDataSourceImpl(get()) as UserLocalDataSource }
    single { TripLocalDataSourceImpl(get()) as TripLocalDataSource }
}

