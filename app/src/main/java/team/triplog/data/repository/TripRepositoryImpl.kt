package team.triplog.data.repository

import team.triplog.data.source.local.TripLocalDataSource
import team.triplog.domain.mapper.toEntity
import team.triplog.domain.model.Trip
import team.triplog.domain.repository.TripRepository


/**
 * Description : 여행 관련 Repository 구현체
 *
 * @author   mjkim
 * @version  1.0.0
 * @since    4/18/21 4:51 PM
 **/
class TripRepositoryImpl(
    private val localDataSource: TripLocalDataSource
) : TripRepository {
    /**
     * 여행 등록
     * @param trip  등록할 여행 정보
     */
    override suspend fun createTrip(trip: Trip) {
        localDataSource.create(trip.toEntity())
    }
}