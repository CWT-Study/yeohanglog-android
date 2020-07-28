package team.triplog.data.remote.mapper

import team.triplog.data.remote.response.TripResponse
import team.triplog.domain.model.TripModel

object TripRemoteMapper : BaseRemoteMapper<TripResponse, TripModel> {
    override fun mapToRemote(from: TripModel): TripResponse {
        return TripResponse(
            id = from.id,
            name = from.name,
            startDate = from.startDate,
            endDate = from.endDate,
            image = from.image
        )
    }

    override fun mapToData(from: TripResponse): TripModel {
        return TripModel(
            id = from.id,
            name = from.name,
            startDate = from.startDate,
            endDate = from.endDate,
            image = from.image
        )
    }
}