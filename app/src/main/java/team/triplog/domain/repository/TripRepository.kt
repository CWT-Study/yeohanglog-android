package team.triplog.domain.repository

import team.triplog.domain.model.Trip


/**
 * @author mjkim
 * @since 2021/06/06
 **/
interface TripRepository {
    /**
     * 여행 등록
     */
    suspend fun createTrip(trip: Trip)
}