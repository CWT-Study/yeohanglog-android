package team.triplog.presentation.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import team.triplog.presentation.viewholder.TripPlanViewHolder
import java.util.*

class TripPlanAdapter(
    private val context: Context,
    private var items: ArrayList<String>
) : RecyclerView.Adapter<TripPlanViewHolder>() {
    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripPlanViewHolder {
        return TripPlanViewHolder.getViewHolder(parent)
    }

    override fun onBindViewHolder(holder: TripPlanViewHolder, position: Int) {
        // TODO : entity 필드와 연결시키기

        val item = items[position]
        holder.bind(item)
    }

    fun setItems(items: ArrayList<String>) {
        this.items = items
        notifyDataSetChanged()
    }
}