package team.triplog.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import team.triplog.presentation.base.BaseViewModel


/**
 * @author mjkim
 * @since 2021.05.14
 */
class TripPlanInfoViewModel : BaseViewModel() {

    /** 이름 설정 여부 */
    private val _hasName = MutableLiveData<Boolean>()
    val hasName: LiveData<Boolean>
        get() = _hasName

    /** 기간 설정 여부 */
    private val _hasPeriod = MutableLiveData<Boolean>()
    val hasPeriod: LiveData<Boolean>
        get() = _hasPeriod

    /** 여행 이름 */
    val tripName = MutableLiveData<String>()


    fun setName(set: Boolean) {
        _hasName.value = set
    }

    fun checkHasData(): Boolean {
        val name = hasName.value ?: false
        val period = hasPeriod.value ?: false

        return name || period
    }
}
