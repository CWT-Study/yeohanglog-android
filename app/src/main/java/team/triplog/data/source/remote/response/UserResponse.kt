package team.triplog.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("_id")
    var id: String,

    @SerializedName("nickname")
    var name: String,

    @SerializedName("profile")
    var profile: String,

    @SerializedName("socialType")
    var socialType: String,

    @SerializedName("socialID")
    var socialID: String,

    @SerializedName("inviteCode")
    var inviteCode: String,

    @SerializedName("pushToken")
    var pushToken: String,

    @SerializedName("createdAt")
    var createdTime: String,

    @SerializedName("updatedAt")
    var updatedTime: String,

    @SerializedName("permission")
    var permission: Permission,

    @SerializedName("push")
    var push: Push

) : BaseResponse {

    data class Permission(
        @SerializedName("info")
        var info: Boolean,

        @SerializedName("ad")
        var ad: Boolean
    )

    data class Push(
        @SerializedName("app")
        var app: Boolean,

        @SerializedName("ad")
        var ad: Boolean
    )
}
