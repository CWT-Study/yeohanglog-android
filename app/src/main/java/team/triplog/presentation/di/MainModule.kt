package team.triplog.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import team.triplog.presentation.viewmodel.*


/**
 * @author mjkim
 * @since 2021/06/06
 **/
val mainModule = module {
    viewModel { ToolbarViewModel() }
    viewModel { MainViewModel() }
    viewModel { MainHomeViewModel() }
    viewModel { ProfileViewModel() }
    viewModel { TripViewModel() }
    viewModel { MainTripLogViewModel() }
    viewModel { UserViewModel(get(), get()) }
    viewModel { TripPlanViewModel(get()) }
    viewModel { TripPlanInfoViewModel() }
    viewModel { TripLogViewModel(get()) }
    viewModel { SettingViewModel() }
}