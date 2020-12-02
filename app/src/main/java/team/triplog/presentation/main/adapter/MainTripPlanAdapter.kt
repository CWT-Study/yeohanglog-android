package team.triplog.presentation.main.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import team.triplog.domain.model.Trip
import team.triplog.presentation.main.viewholder.MainTripPlanViewHolder
import java.util.*

class MainTripPlanAdapter(
    private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<MainTripPlanViewHolder>() {

    private val items: ArrayList<Trip> = arrayListOf()

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainTripPlanViewHolder {
        return MainTripPlanViewHolder.getViewHolder(parent)
    }

    override fun onBindViewHolder(holder: MainTripPlanViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item, onItemClickListener)
    }

    interface OnItemClickListener {
        fun onItemClick(view: View, item: Trip)
    }
}