package team.triplog.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import java.util.*

@Entity(tableName = "Trip")
@TypeConverters(DateConverter::class)
data class Trip (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "name")
    var name: String?,

    @ColumnInfo(name = "startDate")
    var startDate: Date?,

    @ColumnInfo(name = "endDate")
    var endDate: Date?,

    @ColumnInfo(name = "image")
    var image: Int
)