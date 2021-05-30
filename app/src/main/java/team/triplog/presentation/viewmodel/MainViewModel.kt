package team.triplog.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import team.triplog.presentation.base.BaseViewModel
import team.triplog.presentation.util.event.Event


/**
 * @author mjkim
 * @since 2021.05.14
 */
class MainViewModel : BaseViewModel() {

    private val _clickSetting = MutableLiveData<Event<Unit>>()
    val clickSetting: LiveData<Event<Unit>>
        get() = _clickSetting

    fun clickSetting() {
        _clickSetting.value = Event(Unit)
    }
}