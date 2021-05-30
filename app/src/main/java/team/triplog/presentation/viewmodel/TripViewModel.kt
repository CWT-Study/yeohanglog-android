package team.triplog.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import team.triplog.domain.model.Trip
import team.triplog.presentation.base.BaseViewModel
import team.triplog.presentation.util.event.Event


/**
 * @author mjkim
 * @since 2021.05.14
 */
class TripViewModel : BaseViewModel() {

    val planList = MutableLiveData<List<Trip>>()
    val logList = MutableLiveData<List<Trip>>()

    private val _clickCreateTrip = MutableLiveData<Event<Unit>>()
    val clickCreateTrip: LiveData<Event<Unit>>
        get() = _clickCreateTrip

    /**
     * 새로운 여행 등록 메소드
     */
    fun createTrip() {
        _clickCreateTrip.value = Event(Unit)
    }
}