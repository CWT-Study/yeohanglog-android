package team.triplog.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import team.triplog.data.source.local.entity.UserEntity


/**
 * @author mjkim
 * @since 2021/06/06
 **/
@Dao
interface UserDao : BaseDao<UserEntity> {

    @Insert
    fun create(user: UserEntity)

    @Query("select * from user where user_id = :userId")
    fun read(userId: String): UserEntity?

    @Query("select * from user where user_id = :userId")
    fun readAsFlow(userId: Int): Flow<UserEntity?>

}