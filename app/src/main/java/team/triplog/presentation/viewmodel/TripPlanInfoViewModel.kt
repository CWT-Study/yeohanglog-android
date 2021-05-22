package team.triplog.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import team.triplog.presentation.base.BaseViewModel
import team.triplog.presentation.util.event.Event
import team.triplog.presentation.util.extension.toDefaultFormat
import java.util.*


/**
 * @author mjkim
 * @since 2021.05.14
 */
class TripPlanInfoViewModel : BaseViewModel() {

    private val today = Date().toDefaultFormat()

    val tripName = MutableLiveData<String>()
    val startDate = MutableLiveData(today)
    val endDate = MutableLiveData(today)


    private val _eventClickNext = MutableLiveData<Event<Unit>>()
    val eventClickNext: LiveData<Event<Unit>>
        get() = _eventClickNext

    private val _eventClickDate = MutableLiveData<Event<Unit>>()
    val eventClickDate: LiveData<Event<Unit>>
        get() = _eventClickDate

    private val _eventClickEndDate = MutableLiveData<Event<Unit>>()
    val eventClickEndDate: LiveData<Event<Unit>>
        get() = _eventClickEndDate


    // TODO : 기간 설정 여부 확인
    fun checkHasData(): Boolean {
        val hasName = !tripName.value.isNullOrBlank()
        val hasPeriod = false

        return hasName || hasPeriod
    }

    fun clickNext() {
        _eventClickNext.value = Event(Unit)
    }

    fun clickDate() {
        _eventClickDate.value = Event(Unit)
    }
}
