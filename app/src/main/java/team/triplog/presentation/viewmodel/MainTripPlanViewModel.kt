package team.triplog.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import team.triplog.domain.model.Trip
import team.triplog.presentation.base.BaseViewModel


/**
 * @author mjkim
 * @since 2021.05.14
 */
class MainTripPlanViewModel : BaseViewModel() {
    private val _tripPlanList = MutableLiveData<MutableList<Trip>>()
    val tripPlanList: LiveData<MutableList<Trip>> = _tripPlanList
}