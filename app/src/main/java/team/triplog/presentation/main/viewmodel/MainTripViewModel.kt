package team.triplog.presentation.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainTripViewModel : ViewModel() {

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