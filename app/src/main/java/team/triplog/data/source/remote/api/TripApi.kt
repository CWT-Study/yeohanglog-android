package team.triplog.data.source.remote.api

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import team.triplog.data.source.remote.response.TripResponse


/**
 * @author mjkim
 * @since 2021/06/06
 **/
interface TripApi {
    @GET("")
    fun readTrip(): Single<Response<TripResponse>>
}