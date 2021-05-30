package team.triplog.domain.repository

import kotlinx.coroutines.flow.Flow
import team.triplog.domain.model.User


/**
 * @author mjkim
 * @since 2020.10.13
 */
interface UserRepository {

    fun createUser(user: User)

    fun readUserAsFlow(id: Int): Flow<User?>

    fun updateUser(user: User)
}