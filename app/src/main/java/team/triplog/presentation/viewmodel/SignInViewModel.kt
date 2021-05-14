package team.triplog.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kakao.usermgmt.response.model.User
import team.triplog.presentation.base.BaseViewModel


/**
 * @author mjkim
 * @since 2021.05.14
 */
class SignInViewModel : BaseViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

}