package team.triplog.presentation.trip.log.logdetail.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import team.triplog.databinding.ItemTripLogDetailViewpagerBinding
import team.triplog.domain.model.TripLogDetail


/**
 * @author mjkim
 * @since 2021/06/06
 **/
class TripLogDetailViewPagerViewHolder(
    private val binding: ItemTripLogDetailViewpagerBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun getViewHolder(parent: ViewGroup): TripLogDetailViewPagerViewHolder {
            val binding = ItemTripLogDetailViewpagerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return TripLogDetailViewPagerViewHolder(binding)
        }
    }

    fun bind(item: TripLogDetail) {
        // TODO : 종빈쿠
    }
}