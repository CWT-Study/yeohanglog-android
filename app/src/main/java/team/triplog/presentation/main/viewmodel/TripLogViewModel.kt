package team.triplog.presentation.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import team.triplog.data.source.local.entity.TripLog
import team.triplog.domain.usecase.trip.log.TripLogReadUseCase


/**
 * Created by Minjae Kim 2020. 12. 02.
 */
class TripLogViewModel(
    private val tripLogReadUseCase: TripLogReadUseCase
) : ViewModel() {

    private var _tripLogList = MutableLiveData<List<TripLog>>()
    val tripLogList: LiveData<List<TripLog>>
        get() = _tripLogList


    fun updateTripLogList() {
        _tripLogList.value = tripLogReadUseCase.getTripLogs(TRIP_LOG_COUNT)
    }

    companion object {
        private const val TRIP_LOG_COUNT = 8
    }
}
