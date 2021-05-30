package team.triplog.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import team.triplog.presentation.base.BaseViewModel
import team.triplog.presentation.util.event.Event


/**
 * @author mjkim
 * @since 2021.05.19
 */
class ToolbarViewModel : BaseViewModel() {

    val title = MutableLiveData<String>()
    val hasSetting = MutableLiveData<Boolean>()

    private val _eventClickBack = MutableLiveData<Event<Unit>>()
    val eventClickBack: LiveData<Event<Unit>>
        get() = _eventClickBack


    fun clickBack() {
        _eventClickBack.value = Event(Unit)
    }
}
