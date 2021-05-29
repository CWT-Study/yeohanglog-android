package team.triplog.domain.model


/**
 * @since 2021.03.29
 * @author mjkim
 */
data class User(
    val id: Int,
    val name: String,
    val code: String,
    val image: String?
) : BaseModel