package team.triplog.presentation.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import team.triplog.domain.model.TripLog
import team.triplog.presentation.viewholder.MainTripLogViewHolder
import java.util.*

class MainTripLogAdapter(
    private val context: Context?,
    private val items: ArrayList<TripLog>,
    private val onClickListener: OnItemClickListener
) : RecyclerView.Adapter<MainTripLogViewHolder>() {

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainTripLogViewHolder {
        return MainTripLogViewHolder.getViewHolder(parent)
    }

    override fun onBindViewHolder(holder: MainTripLogViewHolder, position: Int) {
        val item = items[position]

        val isAdd = position == itemCount - 1

        holder.bind(item, isAdd, onClickListener)
    }

    interface OnItemClickListener {
        fun onItemClick(item: TripLog)
    }
}