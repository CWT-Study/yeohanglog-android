package team.triplog.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TripResponse(
    @SerializedName("_id")
    var id: String,

    @SerializedName("title")
    var title: String,

    @SerializedName("startDt")
    var startDate: String,

    @SerializedName("endDt")
    var endDate: String,

    @SerializedName("masterId")
    var masterId: String,

    @SerializedName("repPhoto")
    var repPhoto: String,

    @SerializedName("members")
    var members: List<Member>,

    @SerializedName("preparations")
    var preparations: List<String>,

    @SerializedName("readCnt")
    var readCount: String,

    @SerializedName("createdAt")
    var createdTime: String,

    @SerializedName("updatedAt")
    var updatedAt: String

) : BaseResponse {

    data class Member(
        @SerializedName("uuid")
        var memberId: String,

        @SerializedName("authority")
        var authority: Authority
    ) {
        data class Authority(
            @SerializedName("plan")
            var plan: Boolean,

            @SerializedName("file")
            var file: Boolean,

            @SerializedName("cost")
            var cost: Boolean
        )
    }
}
