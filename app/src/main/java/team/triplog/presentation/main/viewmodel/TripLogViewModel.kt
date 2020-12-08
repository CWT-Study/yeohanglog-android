package team.triplog.presentation.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import team.triplog.data.source.local.entity.Trip
import team.triplog.domain.usecase.trip.log.TripLogReadUseCase
import java.util.*


/**
 * Created by Minjae Kim 2020. 12. 02.
 */
class TripLogViewModel(
    private val tripLogReadUseCase: TripLogReadUseCase
) : ViewModel() {

    private var _tripLogList = MutableLiveData<List<Trip>>()
    val tripLogList: LiveData<List<Trip>>
        get() = _tripLogList


    fun updateTripLogList() {
//        _tripLogList.value = tripLogReadUseCase.getTripLogs(TRIP_LOG_COUNT)

        _tripLogList.value = testList()
    }

    // TODO : TEST CODE
    private fun testList(): List<Trip> {
        val list = arrayListOf<Trip>()
        list.add(Trip(id = 1, name = "즐거운 가족여행", startDate = Date(), endDate = Date(), image = ""))
        list.add(Trip(id = 2, name = "제주도 푸른밤", startDate = Date(), endDate = Date(), image = ""))
        list.add(Trip(id = 3, name = "경주 여행", startDate = Date(), endDate = Date(), image = ""))
        list.add(Trip(id = 4, name = "환장의 나라 에버랜드로", startDate = Date(), endDate = Date(), image = ""))
        list.add(Trip(id = 5, name = "이건 몇자까지 보일까 테스트용으로 만듦", startDate = Date(), endDate = Date(), image = ""))
        list.add(Trip(id = 6, name = "방콕", startDate = Date(), endDate = Date(), image = ""))
        list.add(Trip(id = 7, name = "군산 철길마을", startDate = Date(), endDate = Date(), image = ""))

        return list
    }

    companion object {
        private const val TRIP_LOG_COUNT = 8
    }
}
