package team.triplog.data.source.local

import team.triplog.data.source.local.entity.TripEntity


/**
 * @author mjkim
 * @since 2021/06/06
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