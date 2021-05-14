package team.triplog.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import team.triplog.data.source.local.entity.TripEntity
import team.triplog.domain.usecase.trip.log.TripLogReadUseCase
import team.triplog.presentation.base.BaseViewModel
import java.util.*


/**
 * @author mjkim
 * @since 2021.05.14
 */
class TripLogViewModel(
    private val tripLogReadUseCase: TripLogReadUseCase
) : BaseViewModel() {

    private var _tripLogList = MutableLiveData<List<TripEntity>>()
    val tripLogList: LiveData<List<TripEntity>>
        get() = _tripLogList

    fun updateTripLogList() {
        _tripLogList.value = testList()
    }

    // TODO : TEST CODE
    private fun testList(): List<TripEntity> {
        val list = arrayListOf<TripEntity>()
        list.add(
            TripEntity(
                id = 1,
                name = "즐거운 가족여행",
                startDate = Date(),
                endDate = Date(),
                image = ""
            )
        )
        list.add(
            TripEntity(
                id = 2,
                name = "제주도 푸른밤",
                startDate = Date(),
                endDate = Date(),
                image = ""
            )
        )
        list.add(
            TripEntity(
                id = 3,
                name = "경주 여행",
                startDate = Date(),
                endDate = Date(),
                image = ""
            )
        )
        list.add(
            TripEntity(
                id = 4,
                name = "환장의 나라 에버랜드로",
                startDate = Date(),
                endDate = Date(),
                image = ""
            )
        )
        list.add(
            TripEntity(
                id = 5,
                name = "이건 몇자까지 보일까 테스트용으로 만듦",
                startDate = Date(),
                endDate = Date(),
                image = ""
            )
        )
        list.add(TripEntity(id = 6, name = "방콕", startDate = Date(), endDate = Date(), image = ""))
        list.add(
            TripEntity(
                id = 7,
                name = "군산 철길마을",
                startDate = Date(),
                endDate = Date(),
                image = ""
            )
        )

        return list
    }

    companion object {
        private const val TRIP_LOG_COUNT = 8
    }
}
