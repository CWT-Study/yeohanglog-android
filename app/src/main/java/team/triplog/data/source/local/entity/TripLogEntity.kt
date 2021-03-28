package team.triplog.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import team.triplog.data.source.local.Converters
import java.util.*

@Entity(tableName = "TripLog")
@TypeConverters(Converters::class)
data class TripLogEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Long,

    @ColumnInfo(name = "drawableId")
    var drawableId: Int,

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

    @ColumnInfo(name = "content")
    var content: String
) : BaseEntity

