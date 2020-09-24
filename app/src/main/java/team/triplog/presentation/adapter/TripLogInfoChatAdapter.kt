package team.triplog.presentation.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import team.triplog.domain.model.TripLogInfoChat
import team.triplog.presentation.viewholder.TripLogInfoChatViewHolder
import java.util.*

class TripLogInfoChatAdapter(
    private val context: Context,
    private val items: ArrayList<TripLogInfoChat>
) : RecyclerView.Adapter<TripLogInfoChatViewHolder>() {
    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripLogInfoChatViewHolder {
        return TripLogInfoChatViewHolder.getViewHolder(parent)
    }

    override fun onBindViewHolder(holder: TripLogInfoChatViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }
}