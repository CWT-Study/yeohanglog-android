package team.triplog.data.source.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import team.triplog.data.source.local.TripLog

@Dao
interface TripLogDao: BaseDao<TripLog> {

    @Query("SELECT * from TripLog ORDER BY id ASC")
    fun getTripLogList(): LiveData<List<TripLog>>

    @Insert
    fun insertTripLog(tripLog: TripLog)

    @Update
    fun updateTripLog(tripLog: TripLog)

    @Delete
    fun deleteTripLog(tripLog: TripLog)


}