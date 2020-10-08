package team.triplog.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "TripLog")
data class TripLog (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long?,

    @ColumnInfo(name = "drawbleId")
    var drawbleId: Int,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "prevYear")
    var prevYear: Date,

    @ColumnInfo(name = "nextYear")
    var nextYear: Date,

    @ColumnInfo(name = "prevMonth")
    var prevMonth: String,

    @ColumnInfo(name = "nextMonth")
    var nextMonth: String,

    @ColumnInfo(name = "prevDay")
    var prevDay: String,

    @ColumnInfo(name = "nextDay")
    var nextDay: String,

    @ColumnInfo(name = "conent")
    var conent: String
) {
    constructor(): this(null, -1, "", Date(),Date(), "","","","","")
}

