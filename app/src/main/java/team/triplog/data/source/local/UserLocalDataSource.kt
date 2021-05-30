package team.triplog.data.source.local

import kotlinx.coroutines.flow.Flow
import team.triplog.domain.model.User


/**
 * @author mjkim
 * @since 2021.05.30
 */
interface UserLocalDataSource {

    fun create(user: User)

    fun readAll(): List<User>

    fun read(id: String): User?

    fun readAsFlow(id: Int): Flow<User?>

    fun update(user: User)

    fun delete(id: String)

    fun deleteAll()
}