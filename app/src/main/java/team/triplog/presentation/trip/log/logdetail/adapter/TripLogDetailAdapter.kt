package team.triplog.presentation.trip.log.logdetail.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import team.triplog.domain.model.TripLogDetailChat
import team.triplog.presentation.trip.log.logdetail.viewholder.TripLogDetailChatViewHolder
import java.util.*

class TripLogDetailAdapter(
    private val context: Context,
    private val items: ArrayList<TripLogDetailChat>
) : RecyclerView.Adapter<TripLogDetailChatViewHolder>() {
    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripLogDetailChatViewHolder {
        return TripLogDetailChatViewHolder.getViewHolder(parent)
    }

    override fun onBindViewHolder(holder: TripLogDetailChatViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }
}