package team.triplog.presentation.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import team.triplog.R
import team.triplog.data.source.local.TripLog
import team.triplog.databinding.ItemMainTripLogBinding
import team.triplog.presentation.main.adapter.MainTripLogAdapter

class MainTripLogViewHolder(
    private val binding: ItemMainTripLogBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun getViewHolder(parent: ViewGroup): MainTripLogViewHolder {
            val binding =
                ItemMainTripLogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return MainTripLogViewHolder(binding)
        }
    }

    fun bind(item: TripLog, isAdd: Boolean, itemClickListener: MainTripLogAdapter.OnItemClickListener?) {
        if (isAdd) {
            binding.viewGroupImage.setBackgroundResource(R.drawable.button_plus)
            binding.textGroupName.visibility = View.INVISIBLE
        } else {
            binding.viewGroupImage.setBackgroundResource(item.drawableId)
            binding.textGroupName.text = item.title
        }

        binding.layoutMain.setOnClickListener {
            itemClickListener?.onItemClick(item)
        }
    }
}