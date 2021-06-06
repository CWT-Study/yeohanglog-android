package team.triplog.presentation.trip.log.logdetail.viewholder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import team.triplog.R
import team.triplog.databinding.ItemTripLogDetailNumBinding
import team.triplog.domain.model.TripLogDetail


/**
 * @author mjkim
 * @since 2021/06/06
 **/
class TripLogDetailNumViewHolder(
    private val binding: ItemTripLogDetailNumBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun getViewHolder(parent: ViewGroup): TripLogDetailNumViewHolder {
            val binding = ItemTripLogDetailNumBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return TripLogDetailNumViewHolder(binding)
        }
    }

    fun bind(
        context: Context,
        item: TripLogDetail,
        position: Int,
        isLastItem: Boolean
    ) {
        if (position == 0) {
            binding.viewFirst.visibility = View.GONE
            binding.viewLocation.visibility = View.VISIBLE
            binding.viewSelectUser.visibility = View.VISIBLE
            binding.tripLogDetailNum.setTextColor(
                ContextCompat.getColor(
                    context,
                    R.color.trip_log_detail_select_num
                )
            )
        }
        if (isLastItem) {
            binding.viewLast.visibility = View.GONE
        }
    }
}