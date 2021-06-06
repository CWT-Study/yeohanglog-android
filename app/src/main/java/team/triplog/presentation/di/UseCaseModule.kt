package team.triplog.presentation.di

import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module
import team.triplog.domain.usecase.trip.TripCreateUseCase
import team.triplog.domain.usecase.trip.TripStatusUseCase
import team.triplog.domain.usecase.trip.log.TripLogReadUseCase
import team.triplog.domain.usecase.user.ReadUserUseCase
import team.triplog.domain.usecase.user.SignUpUseCase


/**
 * @author mjkim
 * @since 2021/06/06
 **/
val useCaseModule = module {
    single { ReadUserUseCase(get(), Dispatchers.IO) }
    single { SignUpUseCase(get(), Dispatchers.IO) }
    single { TripCreateUseCase(get(), Dispatchers.IO) }
    single { TripStatusUseCase() }
    single { TripLogReadUseCase(get()) }
}