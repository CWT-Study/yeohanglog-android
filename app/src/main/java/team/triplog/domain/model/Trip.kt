package team.triplog.domain.model

import java.util.*


/**
 * @author mjkim
 * @since 2021/06/06
 **/
data class Trip(
    var id: Int = 0,
    var name: String,
    var startDate: Date,
    var endDate: Date,
    var image: String
) : BaseModel