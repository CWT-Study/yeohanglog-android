package team.triplog.domain.model

data class User(
    val id: Int,
    val name: String,
    val code: String,
    val image: String?
) : BaseModel