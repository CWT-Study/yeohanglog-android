package team.triplog.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import team.triplog.data.source.local.dao.UserDao

@Database(entities = [User::class], version = 1)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object{
        @Volatile private var INSTANCE: UserDatabase? = null

        fun getInstance(context: Context): UserDatabase = INSTANCE
            ?:
        synchronized(this) {
            INSTANCE
                ?: buildDatabase(context)
                    .also { INSTANCE = it }
        }

        private  fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                UserDatabase::class.java,"user.db").build()
    }
}