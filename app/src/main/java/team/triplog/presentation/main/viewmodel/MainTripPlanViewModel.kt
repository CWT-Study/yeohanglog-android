package team.triplog.presentation.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import team.triplog.domain.model.Trip

class MainTripPlanViewModel : ViewModel() {

    private val _tripPlanList = MutableLiveData<MutableList<Trip>>()
    val tripPlanList: LiveData<MutableList<Trip>> = _tripPlanList

}