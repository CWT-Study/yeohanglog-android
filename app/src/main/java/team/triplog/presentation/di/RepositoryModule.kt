package team.triplog.presentation.di

import org.koin.dsl.module
import team.triplog.data.repository.TripRepositoryImpl
import team.triplog.domain.repository.TripRepository


/**
 * @author mjkim
 * @since 2021/06/06
 **/
val repositoryModule = module {
    single { TripRepositoryImpl(get()) }
}