package team.triplog.presentation.main.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import team.triplog.databinding.ItemMainTripPlanBinding
import team.triplog.domain.model.Trip
import team.triplog.presentation.main.adapter.MainTripPlanAdapter
import java.text.SimpleDateFormat
import java.util.*


/**
 * @author mjkim
 * @since 2021/06/06
 **/
class MainTripPlanViewHolder(
    private val binding: ItemMainTripPlanBinding
) : RecyclerView.ViewHolder(binding.root) {

    private val yearFormat = SimpleDateFormat("yyyy", Locale.getDefault())
    private val monthFormat = SimpleDateFormat("MMM", Locale.US)
    private val dayFormat = SimpleDateFormat("d", Locale.getDefault())

    companion object {
        fun getViewHolder(parent: ViewGroup): MainTripPlanViewHolder {
            val binding =
                ItemMainTripPlanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return MainTripPlanViewHolder(binding)
        }
    }

    fun bind(item: Trip, itemClickListener: MainTripPlanAdapter.OnItemClickListener) {
        binding.textTripStartYear.text = yearFormat.format(item.startDate)
        binding.textTripStartMonth.text =
            monthFormat.format(item.startDate).toUpperCase(Locale.getDefault())
        binding.textTripStartDay.text = dayFormat.format(item.startDate)
        binding.textTripEndYear.text = yearFormat.format(item.endDate)
        binding.textTripEndMonth.text =
            monthFormat.format(item.endDate).toUpperCase(Locale.getDefault())
        binding.textTripEndDay.text = dayFormat.format(item.endDate)
        binding.textTripName.text = item.name

        binding.layoutItem.setOnClickListener {
            itemClickListener.onItemClick(it, item)
        }
    }
}