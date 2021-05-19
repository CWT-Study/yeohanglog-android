package team.triplog.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import team.triplog.presentation.util.event.Event


/**
 * @author mjkim
 * @since  2021.05.02
 */
abstract class BaseViewModel : ViewModel() {

    private val _eventClickBackground = MutableLiveData<Event<Unit>>()
    val eventClickBackground: LiveData<Event<Unit>>
        get() = _eventClickBackground

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading


    protected fun setLoading(set: Boolean) {
        _isLoading.value = set
    }

    fun clickBackground() {
        _eventClickBackground.value = Event(Unit)
    }
}