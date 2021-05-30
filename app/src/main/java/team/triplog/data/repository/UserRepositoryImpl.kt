package team.triplog.data.repository

import kotlinx.coroutines.flow.Flow
import team.triplog.data.source.local.UserLocalDataSource
import team.triplog.domain.model.User
import team.triplog.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userLocalDataSource: UserLocalDataSource
) : UserRepository {

    override fun createUser(user: User) {
        return userLocalDataSource.create(user)
    }

    override fun readUserAsFlow(id: Int): Flow<User?> {
        return userLocalDataSource.readAsFlow(id)
    }

    override fun updateUser(user: User) {
        // TODO : 업데이트 기능 추가
    }
}