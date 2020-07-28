package team.triplog.data.remote.response

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("id")
    var id: Int = 0,

    @SerializedName("name")
    var name: String = ""
) : BaseResponse
