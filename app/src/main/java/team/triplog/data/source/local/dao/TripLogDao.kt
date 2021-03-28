package team.triplog.data.source.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import team.triplog.data.source.local.entity.TripLogEntity

@Dao
interface TripLogDao: BaseDao<TripLogEntity> {

    @Query("SELECT * from TripLog ORDER BY id ASC")
    fun getTripLogList(): LiveData<List<TripLogEntity>>

    @Insert
    fun insertTripLog(tripLog: TripLogEntity)

    @Update
    fun updateTripLog(tripLog: TripLogEntity)

    @Delete
    fun deleteTripLog(tripLog: TripLogEntity)

}