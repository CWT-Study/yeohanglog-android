package team.triplog.data.source.local

import team.triplog.data.source.local.entity.TripEntity


/**
 * Description : 여행 로컬 데이터소스
 *
 * @author   mjkim
 * @version  1.0.0
 * @since    4/18/21 4:55 PM
 **/
interface TripLocalDataSource {
    /**
     * 여행 등록
     * @param trip  등록할 여행 정보
     */
    fun create(trip: TripEntity)

    fun readAll(): List<TripEntity>

    fun read(id: String): TripEntity?

    fun update(memo: TripEntity)

    fun delete(id: String)

    fun deleteAll()
}