package team.triplog.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import team.triplog.data.local.User

@Dao
interface UserDao : BaseDao<User> {
    @Query("select * from user where user_id = :userId")
    fun read(userId: String): LiveData<User?>

    @Insert
    fun create(user: User)
}