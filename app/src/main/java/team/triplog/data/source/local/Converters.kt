package team.triplog.data.source.local

import androidx.room.TypeConverter
import java.util.*


/**
 * @author mjkim
 * @since 2021/06/06
 **/
class Converters {
    @TypeConverter
    fun longToDate(value: Long): Date = Date(value)

    @TypeConverter
    fun dateToLong(date: Date): Long = date.time
}