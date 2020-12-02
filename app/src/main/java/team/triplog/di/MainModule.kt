package team.triplog.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import team.triplog.presentation.main.viewmodel.*

val mainModule = module {
    viewModel { MainViewModel() }
    viewModel { MainHomeViewModel() }
    viewModel { MainMoreViewModel(get()) }
    viewModel { MainTripViewModel() }
    viewModel { MainTripPlanViewModel() }
    viewModel { MainTripLogViewModel(get()) }

    viewModel { UserViewModel() }

    viewModel { TripLogViewModel() }
}