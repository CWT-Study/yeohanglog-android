package team.triplog.presentation.di

import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module
import team.triplog.domain.usecase.trip.TripCreateUseCase
import team.triplog.domain.usecase.trip.TripStatusUseCase
import team.triplog.domain.usecase.trip.log.TripLogReadUseCase

val useCaseModule = module {
    /** 여행 관련 UseCase */
    single { TripCreateUseCase(get(), Dispatchers.IO) }
    single { TripStatusUseCase() }

    /** 여행 기록 */
    single { TripLogReadUseCase(get()) }
}