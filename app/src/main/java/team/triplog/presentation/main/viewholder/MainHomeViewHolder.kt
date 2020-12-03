package team.triplog.presentation.main.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import team.triplog.data.source.local.TripLog
import team.triplog.databinding.ItemMainHomeTripBinding

import team.triplog.presentation.main.adapter.MainHomeAdapter


class MainHomeViewHolder(
    private val binding: ItemMainHomeTripBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun getViewHolder(parent: ViewGroup): MainHomeViewHolder {
            val binding =
                ItemMainHomeTripBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return MainHomeViewHolder(binding)
        }
    }

    fun bind(item: TripLog, itemClickListener: MainHomeAdapter.OnItemClickListener?) {
        binding.textTripTitle.text = item.title
        binding.viewTrip.setImageResource(item.drawableId)
        binding.layoutItem.tag = item
        binding.layoutItem.setOnClickListener {
            itemClickListener?.onItemClick(item)
        }
    }
}