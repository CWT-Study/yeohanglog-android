package team.triplog.presentation.trip.plan.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import team.triplog.databinding.ItemTripPlanDayBinding


/**
 * @author mjkim
 * @since 2021/06/06
 **/
class TripPlanDayViewHolder(
    private val binding: ItemTripPlanDayBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun getViewHolder(parent: ViewGroup): TripPlanDayViewHolder {
            val binding = ItemTripPlanDayBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return TripPlanDayViewHolder(binding)
        }
    }

    fun bind(item: String) {
        binding.textDay.text = item
    }
}