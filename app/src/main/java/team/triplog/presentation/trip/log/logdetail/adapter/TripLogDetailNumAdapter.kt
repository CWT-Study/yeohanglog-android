package team.triplog.presentation.trip.log.logdetail.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import team.triplog.domain.model.TripLogDetail
import team.triplog.presentation.trip.log.logdetail.viewholder.TripLogDetailNumViewHolder
import java.util.*

class TripLogDetailNumAdapter(
    private val context: Context,
    private val items: ArrayList<TripLogDetail>
) : RecyclerView.Adapter<TripLogDetailNumViewHolder>() {
    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripLogDetailNumViewHolder {
        return TripLogDetailNumViewHolder.getViewHolder(parent)
    }

    override fun onBindViewHolder(holder: TripLogDetailNumViewHolder, position: Int) {
        val item = items[position]

        holder.bind(context, item, position, position == items.size - 1)
    }
}