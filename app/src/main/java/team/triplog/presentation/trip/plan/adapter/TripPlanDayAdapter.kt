package team.triplog.presentation.trip.plan.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import team.triplog.presentation.trip.plan.viewholder.TripPlanDayViewHolder
import java.util.*

class TripPlanDayAdapter(
    private val context: Context,
    private var items: ArrayList<String>
) : RecyclerView.Adapter<TripPlanDayViewHolder>() {

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripPlanDayViewHolder {
        return TripPlanDayViewHolder.getViewHolder(parent)
    }

    override fun onBindViewHolder(holder: TripPlanDayViewHolder, position: Int) {
        val item = items[position]
        holder.bind(context, item)
    }

    fun setItems(items: ArrayList<String>) {
        this.items = items
        notifyDataSetChanged()
    }
}