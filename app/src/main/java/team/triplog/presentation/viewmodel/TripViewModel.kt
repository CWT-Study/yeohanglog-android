package team.triplog.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import team.triplog.domain.model.Trip
import team.triplog.presentation.base.BaseViewModel


/**
 * @author mjkim
 * @since 2021.05.14
 */
class TripViewModel : BaseViewModel() {

    val planList = MutableLiveData<List<Trip>>()
    val logList = MutableLiveData<List<Trip>>()

    private val _eventCreateTrip = MutableLiveData<Unit>()
    val eventCreateTrip: LiveData<Unit>
        get() = _eventCreateTrip

    /**
     * 새로운 여행 등록 메소드
     */
    fun createTrip() {
        _eventCreateTrip.value = Unit
    }
}