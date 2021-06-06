package team.triplog.data.repository

import team.triplog.domain.repository.TripLogRepository
import team.triplog.data.source.local.entity.TripEntity


/**
 * @author mjkim
 * @since 2020/12/02
 **/
class TripLogRepositoryImpl : TripLogRepository {

    /** 새로운 여행 기록하기 */
    override fun createTripLog() {
        // TODO
    }

    /** 여행 기록 전체 가져오기 */
    override fun readAllTripLogs(): List<TripEntity> {
        // TODO
        return arrayListOf()
    }

    /** 특정 개수만큼 여행 기록 가져오기 */
    override fun readTripLogs(count: Int): List<TripEntity> {
        // TODO
        return arrayListOf()
    }

    /** 여행 기록 가져오기 */
    override fun readTripLog(id: Long): TripEntity? {
        // TODO : 나중에 non-null 타입으로 변경 예정
        return null
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