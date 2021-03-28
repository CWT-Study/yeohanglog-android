package team.triplog.data.source.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import team.triplog.data.source.local.entity.UserEntity

@Dao
interface UserDao : BaseDao<UserEntity> {
    @Query("select * from user where user_id = :userId")
    fun read(userId: String): LiveData<UserEntity?>

    @Insert
    fun create(user: UserEntity)
}