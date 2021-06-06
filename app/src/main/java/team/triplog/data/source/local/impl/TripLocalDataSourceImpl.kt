package team.triplog.data.source.local.impl

import team.triplog.data.source.local.TripLocalDataSource
import team.triplog.data.source.local.dao.TripDao
import team.triplog.data.source.local.entity.TripEntity


/**
 * @author mjkim
 * @since 2021/06/06
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