package team.triplog.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import team.triplog.presentation.base.BaseViewModel
import team.triplog.presentation.util.event.Event


/**
 * @author mjkim
 * @since 2021.05.14
 */
class TripPlanInfoViewModel : BaseViewModel() {

    val tripName = MutableLiveData<String>()
    val startDate = MutableLiveData<Long>()
    val endDate = MutableLiveData<Long>()

    private val _eventClickNext = MutableLiveData<Event<Unit>>()
    val eventClickNext: LiveData<Event<Unit>>
        get() = _eventClickNext


    // TODO : 기간 설정 여부 확인
    fun checkHasData(): Boolean {
        val hasName = !tripName.value.isNullOrBlank()
        val hasPeriod = false

        return hasName || hasPeriod
    }

    fun clickNext() {
        _eventClickNext.value = Event(Unit)
    }
}
