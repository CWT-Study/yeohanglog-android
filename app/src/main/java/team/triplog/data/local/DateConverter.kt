/*
 * Created by MinJae Kim on 6/5/20 5:03 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 6/5/20 5:03 PM
 */

package team.triplog.data.local

import androidx.room.TypeConverter
import java.util.*

class DateConverter {
    @TypeConverter
    fun toDate(value: Long): Date = Date(value)

    @TypeConverter
    fun toLong(date: Date): Long = date.time
}