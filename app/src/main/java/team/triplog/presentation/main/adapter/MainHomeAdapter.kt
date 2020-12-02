package team.triplog.presentation.main.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import team.triplog.data.local.TripLog
import team.triplog.presentation.viewholder.MainHomeViewHolder

class MainHomeAdapter(
    var onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<MainHomeViewHolder>() {

    private var items: List<TripLog> = listOf()

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHomeViewHolder {
        return MainHomeViewHolder.getViewHolder(parent)
    }

    override fun onBindViewHolder(holder: MainHomeViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item, onItemClickListener)
    }

    fun updateItems(items: List<TripLog>) {
        this.items = items
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClick(item: TripLog)
    }
}