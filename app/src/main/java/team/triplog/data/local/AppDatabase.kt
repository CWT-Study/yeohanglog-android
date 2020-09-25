package team.triplog.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import team.triplog.data.local.AppDatabase.Companion.DB_VERSION
import team.triplog.data.local.dao.UserDao

@Database(
    entities = [User::class],
    version = DB_VERSION
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        const val DB_NAME = "yeohanglog"
        const val DB_VERSION = 1
    }
}