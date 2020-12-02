package team.triplog.data.repository.impl

import team.triplog.data.repository.TripLogRepository
import team.triplog.data.source.local.TripLog


/**
 * Created by Minjae Kim on 2020.12.02.
 */
class TripLogRepositoryImpl : TripLogRepository {

    /** 새로운 여행 기록하기 */
    override fun createTripLog() {
        // TODO
    }

    /** 여행 기록 전체 가져오기 */
    override fun readAllTripLogs(): List<TripLog> {
        // TODO
        return arrayListOf()
    }

    /** 특정 개수만큼 여행 기록 가져오기 */
    override fun readTripLogs(count: Int): List<TripLog> {
        // TODO
        return arrayListOf()
    }

    /** 여행 기록 가져오기 */
    override fun readTripLog(id: Long): TripLog {
        // TODO
        return TripLog()
    }

    /** 여행 기록 업데이트 */
    override fun updateTripLog(id: Long) {
        // TODO
    }

    /** 여행 기록 삭제하기 */
    override fun deleteTripLog(id: Long) {
        // TODO
    }

}