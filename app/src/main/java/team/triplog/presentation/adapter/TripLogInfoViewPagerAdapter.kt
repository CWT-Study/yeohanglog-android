package team.triplog.presentation.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import team.triplog.domain.model.TripLogInfo
import team.triplog.presentation.viewholder.TripLogInfoViewPagerViewHolder
import java.util.*

class TripLogInfoViewPagerAdapter(
    private val context: Context,
    private val items: ArrayList<TripLogInfo>
) : RecyclerView.Adapter<TripLogInfoViewPagerViewHolder>() {
    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripLogInfoViewPagerViewHolder {
        return TripLogInfoViewPagerViewHolder.getViewHolder(parent)
    }

    override fun onBindViewHolder(holder: TripLogInfoViewPagerViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }
}