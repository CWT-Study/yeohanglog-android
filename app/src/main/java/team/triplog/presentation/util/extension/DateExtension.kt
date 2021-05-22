package team.triplog.presentation.util.extension

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


/**
 * ex) String 2020.12.25 형식
 */
fun Date.toDefaultFormat(): String {
    val format = SimpleDateFormat("yyyy.MM.dd", Locale.getDefault())
    return format.format(this)
}

fun String.toDate(): Date? {
    val format = SimpleDateFormat("yyyy.MM.dd", Locale.getDefault())
    return try {
        format.parse(this)
    } catch (e: ParseException) {
        null
    }
}