package team.triplog.di

import org.koin.dsl.module
import team.triplog.domain.usecase.trip.log.TripLogReadUseCase

val useCaseModule = module {
    /**
     * 여행 기록
     */
    single { TripLogReadUseCase(get()) }
}