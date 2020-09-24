package team.triplog.presentation.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import team.triplog.domain.model.TripLogInfo
import team.triplog.presentation.viewholder.TripLogInfoNumViewHolder
import java.util.*

class TripLogInfoNumAdapter(
    private val context: Context,
    private val items: ArrayList<TripLogInfo>
) : RecyclerView.Adapter<TripLogInfoNumViewHolder>() {
    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripLogInfoNumViewHolder {
        return TripLogInfoNumViewHolder.getViewHolder(parent)
    }

    override fun onBindViewHolder(holder: TripLogInfoNumViewHolder, position: Int) {
        val item = items[position]

        holder.bind(context, item, position, position == items.size - 1)
    }
}