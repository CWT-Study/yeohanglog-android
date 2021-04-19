package team.triplog.domain.repository

import dev.lazyrabbit.rememberize.util.result.Result
import kotlinx.coroutines.flow.Flow
import team.triplog.domain.model.Trip


/**
 * Description : 여행 관련 Repository
 *
 * @author   mjkim
 * @version  1.0.0
 * @since    4/18/21 4:47 PM
 **/
interface TripRepository {
    /**
     * 여행 등록
     */
    suspend fun createTrip(trip: Trip)
}