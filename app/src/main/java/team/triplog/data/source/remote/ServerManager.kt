package team.triplog.data.source.remote

import retrofit2.Response
import team.triplog.data.source.remote.response.TripResponse
import team.triplog.data.source.remote.response.UserResponse
import java.util.*

class ServerManager {
    companion object {
        private val SERVER = ServerDefine.retrofit.create(ServerInterface::class.java)
    }

    fun getUser(userId: Int): Response<UserResponse> {
        return SERVER.getUser(userId)
    }

    fun getTrips(userId: Int): Response<ArrayList<TripResponse>> {
        return SERVER.getTrips(userId)
    }
}