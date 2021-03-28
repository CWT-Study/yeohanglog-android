package team.triplog.domain.model

import java.util.*

data class TripLog(
    val id: Long,
    val content: String,
    var title: String,
    var prevYear: Date,
    var nextYear: Date,
    var prevMonth: String,
    var nextMonth: String,
    var start: String,
    var nextDay: String
) : BaseModel
