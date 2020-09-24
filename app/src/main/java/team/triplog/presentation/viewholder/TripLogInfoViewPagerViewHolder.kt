package team.triplog.presentation.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import team.triplog.databinding.ItemTripLogInfoViewpagerBinding
import team.triplog.domain.model.TripLogInfo

class TripLogInfoViewPagerViewHolder(
    private val binding: ItemTripLogInfoViewpagerBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun getViewHolder(parent: ViewGroup): TripLogInfoViewPagerViewHolder {
            val binding =
                ItemTripLogInfoViewpagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return TripLogInfoViewPagerViewHolder(binding)
        }
    }

    fun bind(item: TripLogInfo) {
        // TODO : 종빈쿠
    }
}