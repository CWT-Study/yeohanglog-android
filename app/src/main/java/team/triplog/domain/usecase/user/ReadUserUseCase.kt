package team.triplog.domain.usecase.user

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import team.triplog.domain.model.User
import team.triplog.domain.repository.UserRepository
import team.triplog.domain.usecase.base.BaseUseCase


/**
 * @author mjkim
 * @since 2021.05.30
 */
class ReadUserUseCase(
    private val userRepository: UserRepository,
    dispatcher: CoroutineDispatcher
) : BaseUseCase<Unit, Flow<User?>>(dispatcher) {

    override suspend fun execute(parameters: Unit): Flow<User?> {
        return userRepository.readUserAsFlow(id = 1)
    }
}