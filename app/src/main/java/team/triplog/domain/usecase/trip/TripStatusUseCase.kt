package team.triplog.domain.usecase.trip

import team.triplog.domain.model.Trip
import team.triplog.domain.model.TripStatus
import java.util.*


/**
 * @author mjkim
 * @since 2021/06/06
 **/
class TripStatusUseCase {
    /**
     * 현재 여행정보를 가지고 여행의 상태를 나타내어 반환함.
     */
    fun setTripStatus(trip: Trip?): TripStatus {
        val today = Date()

        return trip?.let {
            val isPlanned = today.before(it.startDate)
            val isTraveling = (today.time >= it.startDate.time) && (today.time <= it.endDate.time)
            when {
                isPlanned -> TripStatus.PLANNED_TRIP
                isTraveling -> TripStatus.TRAVELING
                else -> TripStatus.NO_TRIP
            }
        } ?: TripStatus.NO_TRIP
    }
}