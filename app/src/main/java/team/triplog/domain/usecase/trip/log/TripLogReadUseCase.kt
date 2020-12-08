package team.triplog.domain.usecase.trip.log

import team.triplog.data.repository.TripLogRepository
import team.triplog.data.source.local.entity.TripLog


/**
 * Created by Minjae Kim on 2020.12.02.
 */
class TripLogReadUseCase(private val tripLogRepository: TripLogRepository) {

    /** 여행 기록 전체 가져오기 */
    fun getAllTripLogs(): List<TripLog> {
        return tripLogRepository.readAllTripLogs()
    }

    /** 특정 개수만큼 여행 기록 가져오기 */
    fun getTripLogs(count: Int): List<TripLog> {
        return tripLogRepository.readTripLogs(count)
    }

    /** 여행 기록 가져오기 */
    fun getTripLog(id: Long): TripLog? {
        return tripLogRepository.readTripLog(id)
    }

}