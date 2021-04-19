package team.triplog.presentation.di

import org.koin.dsl.module
import team.triplog.data.source.local.TripLocalDataSource
import team.triplog.data.source.local.impl.TripLocalDataSourceImpl


val remoteDataSourceModule = module {
}

val localDataSourceModule = module {
    single { TripLocalDataSourceImpl(get()) as TripLocalDataSource }
}

