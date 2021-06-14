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

    private val _clickProfileImage = MutableLiveData<Event<Unit>>()
    val clickProfileImage: LiveData<Event<Unit>>
        get() = _clickProfileImage


    fun clickMoveSignIn() {
        _clickMoveSignIn.value = Event(Unit)
    }

    // TODO : 추후 이미지가 아니라 따로 버튼을 만들어서 프로필 이미지를 수정하는 function 을 만들어야함
    fun clickProfileImage() {
        _clickProfileImage.value = Event(Unit)
    }
}