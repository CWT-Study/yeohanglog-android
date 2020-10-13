package team.triplog.domain.model

import java.util.*

data class TripLog(
    var drawableId: Int,
    var title: String,
    var prevYear: Date,
    var nextYear: Date,
    var prevMonth: String,
    var nextMonth: String,
    var prevDay: String,
    var nextDay: String,
    var conent: String
) : BaseModel
