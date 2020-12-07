package team.triplog.domain.usecase.trip

import team.triplog.data.source.local.entity.Trip
import team.triplog.data.status.TripStatus
import java.util.*


/**
 * Created by Minjae Kim on 2020. 12. 06
 *
 * TripStatusUseCase
 *  - 여행의 진행상태를 확인하는 로직이 담긴 유즈케이스
 */
class TripStatusUseCase {

    /**
     * 현재 여행정보를 가지고 여행의 상태를 나타내어 반환함.
     */
    fun setTripStatus(trip: Trip?): TripStatus {
        val today = Date()

        return trip?.let {
            val isPlanned = today.before(trip.startDate)
            val isTraveling = (today.time >= trip.startDate.time) && (today.time <= trip.endDate.time)
            when {
                isPlanned -> TripStatus.PLANNED_TRIP
                isTraveling -> TripStatus.TRAVELING
                else -> TripStatus.NO_TRIP
            }
        } ?: TripStatus.NO_TRIP
    }
}