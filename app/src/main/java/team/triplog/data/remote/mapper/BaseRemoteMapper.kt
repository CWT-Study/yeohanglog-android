package team.triplog.data.remote.mapper

import team.triplog.data.remote.response.BaseResponse
import team.triplog.domain.model.BaseModel

interface BaseRemoteMapper<Remote : BaseResponse, Data : BaseModel> {
    fun mapToRemote(from: Data): Remote
    fun mapToData(from: Remote): Data
}