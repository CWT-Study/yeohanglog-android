package team.triplog.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import team.triplog.presentation.base.BaseViewModel
import team.triplog.presentation.util.event.Event


/**
 * @author mjkim
 * @since 2021.05.14
 */
class ProfileViewModel : BaseViewModel() {

    private val _clickMoveSignIn = MutableLiveData<Event<Unit>>()
    val clickMoveSignIn: LiveData<Event<Unit>>
        get() = _clickMoveSignIn

    fun clickMoveSignIn() {
        _clickMoveSignIn.value = Event(Unit)
    }
}