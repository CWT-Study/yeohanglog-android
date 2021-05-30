package team.triplog.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import team.triplog.domain.model.User
import team.triplog.domain.repository.UserRepository
import team.triplog.domain.usecase.user.SignUpUseCase
import team.triplog.presentation.base.BaseViewModel


/**
 * @author mjkim
 * @since 2021.05.14
 */
class UserViewModel(
    private val userRepository: UserRepository,
    private val signUpUseCase: SignUpUseCase
) : BaseViewModel() {

    val user: LiveData<User?> = userRepository
        .readUserAsFlow(1)
        .asLiveData(Dispatchers.IO)

    /**
     * TODO : User 정보 임시 생성 (추후 서버 연동)
     */
    fun signUp() {
        viewModelScope.launch {
            val user = User(
                id = 1,
                name = "김민재",
                code = "1234",
                image = null
            )
            signUpUseCase(user)
        }
    }
}
