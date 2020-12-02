package team.triplog.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import team.triplog.data.source.local.dao.TripDao


@Database(entities = [Trip::class], version = 1)
abstract class TripDatabase: RoomDatabase() {
    abstract fun tripDao(): TripDao

    companion object{
        @Volatile private var INSTANCE: TripDatabase? = null

        fun getInstance(context: Context): TripDatabase = INSTANCE
            ?:
        synchronized(this) {
            INSTANCE
                ?: buildDatabase(context)
                    .also { INSTANCE = it }
        }

        private  fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                TripDatabase::class.java,"Trip.db").build()
    }
}