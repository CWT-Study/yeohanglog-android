package team.triplog.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import team.triplog.data.source.local.Converters
import java.util.*


/**
 * @author mjkim
 * @since 2021/06/06
 **/
@Entity(tableName = "Trip")
@TypeConverters(Converters::class)
data class TripEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "startDate")
    var startDate: Date,

    @ColumnInfo(name = "endDate")
    var endDate: Date,

    @ColumnInfo(name = "image")
    var image: String
) : BaseEntity