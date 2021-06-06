package team.triplog.domain.repository

import team.triplog.data.source.local.entity.TripEntity


/**
 * @author mjkim
 * @since 2021/06/06
 **/
interface TripLogRepository {

    /** 새로운 여행 기록하기 */
    fun createTripLog()

    /** 여행 기록 전체 가져오기 */
    fun readAllTripLogs(): List<TripEntity>

    /** 특정 개수만큼 여행 기록 가져오기 */
    fun readTripLogs(count: Int): List<TripEntity>

    /** 여행 기록 가져오기 */
    fun readTripLog(id: Long): TripEntity?

    /** 여행 기록 업데이트 */
    fun updateTripLog(id: Long)

    /** 여행 기록 삭제하기 */
    fun deleteTripLog(id: Long)

}
