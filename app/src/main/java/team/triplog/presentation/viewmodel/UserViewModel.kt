package team.triplog.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import team.triplog.domain.model.User
import team.triplog.presentation.base.BaseViewModel


/**
 * @author mjkim
 * @since 2021.05.14
 */
class UserViewModel : BaseViewModel() {

    val user = MutableLiveData<User>()
}
