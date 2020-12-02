package team.triplog.presentation.trip.log.logdetail.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import team.triplog.domain.model.TripLogDetail
import team.triplog.presentation.trip.log.logdetail.viewholder.TripLogDetailViewPagerViewHolder
import java.util.*

class TripLogDetailViewPagerAdapter(
    private val context: Context,
    private val items: ArrayList<TripLogDetail>
) : RecyclerView.Adapter<TripLogDetailViewPagerViewHolder>() {
    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripLogDetailViewPagerViewHolder {
        return TripLogDetailViewPagerViewHolder.getViewHolder(parent)
    }

    override fun onBindViewHolder(holder: TripLogDetailViewPagerViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }
}