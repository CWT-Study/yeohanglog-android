package team.triplog.presentation.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import team.triplog.databinding.ItemTripPlanBinding

class TripPlanViewHolder(
    private val binding: ItemTripPlanBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun getViewHolder(parent: ViewGroup): TripPlanViewHolder {
            val binding =
                ItemTripPlanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return TripPlanViewHolder(binding)
        }
    }

    fun bind(item: String) {
        binding.textLocation.text = item
    }
}