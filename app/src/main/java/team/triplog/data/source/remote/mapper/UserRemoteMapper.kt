package team.triplog.data.source.remote.mapper

import team.triplog.data.source.remote.response.UserResponse
import team.triplog.domain.model.UserModel

object UserRemoteMapper :
    BaseRemoteMapper<UserResponse, UserModel> {
    override fun mapToRemote(from: UserModel): UserResponse {
        return UserResponse(
            id = from.id,
            name = from.name
        )
    }

    override fun mapToData(from: UserResponse): UserModel {
        return UserModel(
            id = from.id,
            name = from.name
        )
    }
}