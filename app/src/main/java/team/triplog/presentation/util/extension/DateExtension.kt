package team.triplog.presentation.util.extension

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


/**
 * @author mjkim
 * @since 2021/06/06
 **/

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