package team.triplog.presentation.di

import androidx.room.Room
import org.koin.dsl.module
import team.triplog.data.repository.UserRepositoryImpl
import team.triplog.data.source.local.AppDatabase
import team.triplog.domain.repository.UserRepository

val roomModule = module {
    single { Room.databaseBuilder(get(), AppDatabase::class.java, AppDatabase.DB_NAME).build() }
    single { get<AppDatabase>().userDao() }
    single { get<AppDatabase>().tripDao() }
}

val dataModule = module {
    single { UserRepositoryImpl(get()) as UserRepository }
}