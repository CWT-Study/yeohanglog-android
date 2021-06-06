package team.triplog.domain.usecase.trip.log

import team.triplog.data.source.local.entity.TripEntity
import team.triplog.domain.repository.TripLogRepository


/**
 * @author mjkim
 * @since 2021/06/06
 **/
class TripLogReadUseCase(private val tripLogRepository: TripLogRepository) {

    /** 여행 기록 전체 가져오기 */
    fun getAllTripLogs(): List<TripEntity> {
        return tripLogRepository.readAllTripLogs()
    }

    /** 특정 개수만큼 여행 기록 가져오기 */
    fun getTripLogs(count: Int): List<TripEntity> {
        return tripLogRepository.readTripLogs(count)
    }

    /** 여행 기록 가져오기 */
    fun getTripLog(id: Long): TripEntity? {
        return tripLogRepository.readTripLog(id)
    }

}