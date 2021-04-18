package team.triplog.presentation.di

import org.koin.dsl.module
import team.triplog.domain.usecase.trip.TripStatusUseCase
import team.triplog.domain.usecase.trip.log.TripLogReadUseCase

val useCaseModule = module {

    /** 여행 기록 */
    single { TripLogReadUseCase(get()) }

    /** 여행의 진행상태 확인 */
    single { TripStatusUseCase() }
}