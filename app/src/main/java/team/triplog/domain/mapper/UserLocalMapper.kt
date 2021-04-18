package team.triplog.domain.mapper

import team.triplog.data.source.local.entity.UserEntity
import team.triplog.domain.model.User


/**
 * @author Man-jae
 * @since 2021.03.29.
 */

fun UserEntity.toModel(): User {
    return User(
        id = this.id,
        name = this.name,
        image = this.image
    )
}

fun User.toEntity(): UserEntity {
    return UserEntity(
        id = this.id,
        name = this.name,
        image = this.image
    )
}