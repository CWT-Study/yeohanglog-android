package team.triplog.presentation.main.adapter

import androidx.recyclerview.widget.DiffUtil
import team.triplog.data.local.TripLog

class MainTripLogDiffCallback(val oldTripLogList: List<TripLog>, val newTripLogList: List<TripLog>): DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldTripLogList[oldItemPosition].id == newTripLogList[newItemPosition].id
    }

    override fun getOldListSize(): Int = oldTripLogList.size


    override fun getNewListSize(): Int  = newTripLogList.size

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return newTripLogList[newItemPosition].equals(oldTripLogList[oldItemPosition])
    }

}