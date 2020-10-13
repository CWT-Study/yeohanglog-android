package team.triplog.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import team.triplog.data.local.dao.TripLogDao

@Database(entities = [TripLog::class], version = 1)
abstract class TripLogDatabase: RoomDatabase() {
    abstract fun tripDao(): TripLogDao

    companion object{
        @Volatile private var INSTANCE: TripLogDatabase? = null

        fun getInstance(context: Context): TripLogDatabase = INSTANCE ?:
        synchronized(this) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }

        private  fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                TripLogDatabase::class.java,"TripLog.db").build()
    }
}