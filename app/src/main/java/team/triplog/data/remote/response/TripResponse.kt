package team.triplog.data.remote.response

import com.google.gson.annotations.SerializedName
import java.util.*

data class TripResponse(
    @SerializedName("id")
    var id: Int = 0,

    @SerializedName("name")
    var name: String = "",

    @SerializedName("start_at")
    var startDate: Date = Date(),

    @SerializedName("end_at")
    var endDate: Date = Date(),

    @SerializedName("image")
    var image: String = ""
) : BaseResponse
