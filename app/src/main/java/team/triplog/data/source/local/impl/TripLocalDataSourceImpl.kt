package team.triplog.data.source.local.impl

import team.triplog.data.source.local.TripLocalDataSource
import team.triplog.data.source.local.dao.TripDao
import team.triplog.data.source.local.entity.TripEntity


/**
 * Description : 여행 로컬 데이터소스 구현체
 *
 * @author   mjkim
 * @version  1.0.0
 * @since    4/19/21 11:40 PM
 **/
class TripLocalDataSourceImpl(
    private val tripDao: TripDao
) : TripLocalDataSource {
    /**
     * 여행 등록
     * @param trip  등록할 여행 정보
     */
    override fun create(trip: TripEntity) {
        tripDao.insertTrip(trip)
    }

    override fun readAll(): List<TripEntity> {
        TODO("Not yet implemented")
    }

    override fun read(id: String): TripEntity? {
        TODO("Not yet implemented")
    }

    override fun update(memo: TripEntity) {
        TODO("Not yet implemented")
    }

    override fun delete(id: String) {
        TODO("Not yet implemented")
    }

    override fun deleteAll() {
        TODO("Not yet implemented")
    }
}