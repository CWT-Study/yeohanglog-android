package team.triplog.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import team.triplog.data.remote.response.TripResponse
import team.triplog.data.remote.response.UserResponse
import java.util.*

interface ServerInterface {
    companion object {
        // 임시 URL
        private const val USER = "user"
        private const val USER_ID = "user_id"

        private const val TRIP = "trip"
        private const val TRIP_ID = "trip_id"
    }


    @GET(USER)
    fun getUser(
        @Path(USER_ID) userId: Int
    ): Response<UserResponse>

    @GET(TRIP)
    fun getTrips(
        @Path(USER_ID) userId: Int
    ): Response<ArrayList<TripResponse>>
}