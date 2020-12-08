package team.triplog.presentation.util.extension

import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by Minjae Kim on 2020.12.08.
 */


/**
 * ex) String 2020.12.25 형식
 */
fun Date.toDefaultFormat(): String {
    val format = SimpleDateFormat("yyyy.MM.dd", Locale.getDefault())
    return format.format(this)
}