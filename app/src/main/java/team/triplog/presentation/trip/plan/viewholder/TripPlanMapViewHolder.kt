package team.triplog.presentation.trip.plan.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import team.triplog.databinding.ItemTripPlanBinding


/**
 * @author mjkim
 * @since 2021/06/06
 **/
class TripPlanMapViewHolder(
    private val binding: ItemTripPlanBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun getViewHolder(parent: ViewGroup): TripPlanMapViewHolder {
            val binding = ItemTripPlanBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return TripPlanMapViewHolder(binding)
        }
    }

    fun bind(item: String) {
        binding.textLocation.text = item
    }
}