package team.triplog.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import team.triplog.data.local.Trip
import team.triplog.data.local.TripLog

@Dao
interface TripDao: BaseDao<Trip> {

    @Query("select * from trip where id = :tripId")
    fun getTrip(tripId: String): LiveData<Trip>

    @Insert
    fun insertTrip(trip: Trip)

    @Update
    fun updateTrip(trip: Trip)

    @Delete
    fun deleteTrip(trip: Trip)


}