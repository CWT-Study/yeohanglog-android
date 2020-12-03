/*
 * Created by MinJae Kim on 6/5/20 5:03 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 6/5/20 5:03 PM
 */

package team.triplog.data.source.local

import androidx.room.TypeConverter
import java.util.*

class Converters {
    @TypeConverter
    fun longToDate(value: Long): Date = Date(value)

    @TypeConverter
    fun dateToLong(date: Date): Long = date.time
}