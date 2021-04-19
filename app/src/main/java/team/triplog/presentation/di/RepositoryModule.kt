package team.triplog.presentation.di

import org.koin.dsl.module
import team.triplog.data.repository.TripRepositoryImpl
import team.triplog.domain.repository.TripRepository

val repositoryModule = module {
    single { TripRepositoryImpl(get()) as TripRepository }
}