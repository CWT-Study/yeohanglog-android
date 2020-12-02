package team.triplog.di

import androidx.room.Room
import org.koin.dsl.module
import team.triplog.data.source.local.AppDatabase

val roomModule = module {
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, AppDatabase.DB_NAME).build()
    }
}