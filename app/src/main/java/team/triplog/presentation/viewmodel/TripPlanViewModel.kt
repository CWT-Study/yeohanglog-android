package team.triplog.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import team.triplog.domain.model.Trip
import team.triplog.domain.model.TripStatus
import team.triplog.domain.usecase.trip.TripStatusUseCase
import team.triplog.presentation.base.BaseViewModel


/**
 * @author mjkim
 * @since 2021.05.14
 */
class TripPlanViewModel(
    private val tripStatusUseCase: TripStatusUseCase
) : BaseViewModel() {

    private var _mainTripPlan = MutableLiveData<Trip>()
    val mainTripPlan: LiveData<Trip>
        get() = _mainTripPlan

    private var _eventClickTripButton = MutableLiveData<Trip?>()
    val eventClickTripButton: LiveData<Trip?>
        get() = _eventClickTripButton

    private var currentTripStatus = TripStatus.NO_TRIP


    /**
     * 메인화면 여행 등록/일정 화면 이동 버튼
     */
    fun clickTripButton() {
        _eventClickTripButton.value = _mainTripPlan.value
    }

    fun updateCurrentTripStatus() {
        currentTripStatus = tripStatusUseCase.setTripStatus(_mainTripPlan.value)
    }
}
