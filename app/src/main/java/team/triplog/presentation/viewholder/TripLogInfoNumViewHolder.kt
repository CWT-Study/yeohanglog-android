package team.triplog.presentation.viewholder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import team.triplog.R
import team.triplog.databinding.ItemTripLogInfoNumBinding
import team.triplog.domain.model.TripLogInfo

class TripLogInfoNumViewHolder(
    private val binding: ItemTripLogInfoNumBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun getViewHolder(parent: ViewGroup): TripLogInfoNumViewHolder {
            // TODO : item_trip_info_user 이름 변경 필요.
            val binding =
                ItemTripLogInfoNumBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return TripLogInfoNumViewHolder(binding)
        }
    }

    fun bind(context: Context, item: TripLogInfo, position: Int, isLastItem: Boolean) {
        // TODO : 첫번째, 마지막 아이템을 어떻게 알아서 처리할지 다시 생각 필요합니다.
        // TODO : 종빈쿠
        if (position == 0) {
            binding.viewFirst.visibility = View.GONE
            binding.viewLocation.visibility = View.VISIBLE
            binding.viewSelectUser.visibility = View.VISIBLE
            binding.tripLogInfoNum.setTextColor(ContextCompat.getColor(context, R.color.trip_log_info_select_num))
        }
        if (isLastItem) {
            binding.viewLast.visibility = View.GONE
        }
    }
}