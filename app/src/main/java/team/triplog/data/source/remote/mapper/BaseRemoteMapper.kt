package team.triplog.data.source.remote.mapper

import team.triplog.data.source.remote.response.BaseResponse
import team.triplog.domain.model.BaseModel

interface BaseRemoteMapper<Remote : BaseResponse, Data : BaseModel> {
    fun mapToRemote(from: Data): Remote
    fun mapToData(from: Remote): Data
}