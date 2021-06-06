package team.triplog.presentation.main.adapter

import androidx.recyclerview.widget.DiffUtil
import team.triplog.data.source.local.entity.TripLogEntity


/**
 * @author mjkim
 * @since 2021/06/06
 **/
class MainHomeDiffCallback(
    val oldTripLogList: List<TripLogEntity>,
    val newTripLogList: List<TripLogEntity>
) : DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldTripLogList[oldItemPosition].id == newTripLogList[newItemPosition].id
    }

    override fun getOldListSize(): Int = oldTripLogList.size


    override fun getNewListSize(): Int = newTripLogList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return newTripLogList[newItemPosition].equals(oldTripLogList[oldItemPosition])
    }

}