package team.triplog.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import team.triplog.presentation.viewmodel.*

val mainModule = module {
    viewModel { MainViewModel() }
    viewModel { MainHomeViewModel() }
    viewModel { MainMoreViewModel(get()) }
    viewModel { MainTripViewModel() }
    viewModel { MainTripPlanViewModel() }
    viewModel { MainTripLogViewModel(get()) }

    viewModel { UserViewModel() }

    viewModel { TripPlanViewModel(get()) }
    viewModel { TripPlanInfoViewModel() }
    viewModel { TripLogViewModel(get()) }
}