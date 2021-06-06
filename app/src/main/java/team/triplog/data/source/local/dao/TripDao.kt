package team.triplog.data.source.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import team.triplog.data.source.local.entity.TripEntity


/**
 * @author mjkim
 * @since 2021/06/06
 **/
@Dao
interface TripDao: BaseDao<TripEntity> {

    @Query("select * from trip where id = :tripId")
    fun getTrip(tripId: String): LiveData<TripEntity>

    @Insert
    fun insertTrip(trip: TripEntity)

    @Update
    fun updateTrip(trip: TripEntity)

    @Delete
    fun deleteTrip(trip: TripEntity)


}