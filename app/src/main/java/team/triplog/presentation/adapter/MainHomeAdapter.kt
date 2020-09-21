package team.triplog.presentation.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import team.triplog.domain.model.TripLog
import team.triplog.presentation.viewholder.MainHomeViewHolder
import java.util.*

class MainHomeAdapter(
    private val context: Context,
    private val items: ArrayList<TripLog>,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<MainHomeViewHolder>() {

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHomeViewHolder {
        return MainHomeViewHolder.getViewHolder(parent)
    }

    override fun onBindViewHolder(holder: MainHomeViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item, itemClickListener)
    }

    interface OnItemClickListener {
        fun onItemClick(item: TripLog)
    }
}