package team.triplog.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import team.triplog.presentation.viewModel.MainViewModel

val mainModule = module {
    viewModel { MainViewModel() }
}