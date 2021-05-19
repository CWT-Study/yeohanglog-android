package team.triplog.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import team.triplog.presentation.base.BaseViewModel


/**
 * @author mjkim
 * @since 2021.05.14
 */
class TripPlanInfoViewModel : BaseViewModel() {

    val tripName = MutableLiveData<String>()
    val startDate = MutableLiveData<Long>()
    val endDate = MutableLiveData<Long>()

}
