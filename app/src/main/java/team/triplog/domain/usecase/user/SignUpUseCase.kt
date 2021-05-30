package team.triplog.domain.usecase.user

import kotlinx.coroutines.CoroutineDispatcher
import team.triplog.domain.model.User
import team.triplog.domain.repository.UserRepository
import team.triplog.domain.usecase.base.BaseUseCase


/**
 * @author mjkim
 * @since 2021.05.30
 */
class SignUpUseCase(
    private val userRepository: UserRepository,
    dispatcher: CoroutineDispatcher
) : BaseUseCase<User, Unit>(dispatcher) {

    override suspend fun execute(parameters: User) {
        userRepository.createUser(user = parameters)
    }
}