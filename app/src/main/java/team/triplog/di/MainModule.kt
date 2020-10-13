package team.triplog.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import team.triplog.presentation.main.viewmodel.MainHomeViewModel
import team.triplog.presentation.main.viewmodel.MainViewModel

val mainModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { MainHomeViewModel(get()) }
}