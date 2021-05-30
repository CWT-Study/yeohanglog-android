package team.triplog.data.source.local.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import team.triplog.data.source.local.UserLocalDataSource
import team.triplog.data.source.local.dao.UserDao
import team.triplog.domain.mapper.toEntity
import team.triplog.domain.mapper.toModel
import team.triplog.domain.model.User


/**
 * @author mjkim
 * @since 2021.05.30
 */
class UserLocalDataSourceImpl(
    private val userDao: UserDao
) : UserLocalDataSource {

    override fun create(user: User) {
        userDao.create(user.toEntity())
    }

    override fun readAll(): List<User> {
        TODO("Not yet implemented")
    }

    override fun read(id: String): User? {
        TODO("Not yet implemented")
    }

    override fun readAsFlow(id: Int): Flow<User?> {
        return userDao.readAsFlow(id).map { it?.toModel() }
    }

    override fun update(user: User) {
        TODO("Not yet implemented")
    }

    override fun delete(id: String) {
        TODO("Not yet implemented")
    }

    override fun deleteAll() {
        TODO("Not yet implemented")
    }
}