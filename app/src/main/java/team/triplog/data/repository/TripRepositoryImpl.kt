package team.triplog.data.repository

import team.triplog.data.source.local.TripLocalDataSource
import team.triplog.domain.mapper.toEntity
import team.triplog.domain.model.Trip
import team.triplog.domain.repository.TripRepository


/**
 * @author mjkim
 * @since 2021/03/29
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