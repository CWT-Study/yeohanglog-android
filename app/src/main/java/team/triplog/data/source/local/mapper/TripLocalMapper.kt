package team.triplog.data.source.local.mapper

import team.triplog.data.source.local.entity.TripEntity
import team.triplog.data.source.local.entity.UserEntity
import team.triplog.domain.model.Trip
import team.triplog.domain.model.User


/**
 * @author Man-jae
 * @since 2021.03.29.
 */

fun TripEntity.toModel(): Trip {
    return Trip(
        id = this.id,
        name = this.name,
        startDate = this.startDate,
        endDate = this.endDate,
        image = this.image
    )
}

fun Trip.toEntity(): TripEntity {
    return TripEntity(
        id = this.id,
        name = this.name,
        startDate = this.startDate,
        endDate = this.endDate,
        image = this.image
    )
}