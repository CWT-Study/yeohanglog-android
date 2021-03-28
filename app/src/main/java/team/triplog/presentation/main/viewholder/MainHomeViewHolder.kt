package team.triplog.presentation.main.viewholder

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import team.triplog.data.source.local.entity.TripEntity
import team.triplog.databinding.ItemMainHomeTripBinding
import team.triplog.presentation.main.adapter.MainHomeAdapter
import team.triplog.presentation.util.extension.setupButton
import team.triplog.presentation.util.extension.toDefaultFormat
import java.util.*


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

    @SuppressLint("ClickableViewAccessibility")
    fun bind(item: TripEntity, itemClickListener: MainHomeAdapter.OnItemClickListener) {
        // TODO : 여행기록 대표 이미지 표시 추가

        binding.tvTripTitle.text = item.name
        binding.tvTripTitle.isSelected = true
        binding.tvTripTitle.setHorizontallyScrolling(true)
        binding.tvTripPeriod.text = setPeriodString(item.startDate, item.endDate)
        itemView.setupButton()
        itemView.setOnClickListener {
            itemClickListener.onItemClick(item)
        }
    }

    private fun setPeriodString(start: Date, end: Date): String {
        return String.format("${start.toDefaultFormat()} - ${end.toDefaultFormat()}")
    }
}