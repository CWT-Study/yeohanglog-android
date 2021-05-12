package team.triplog.presentation.trip.plan.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import team.triplog.presentation.trip.plan.viewholder.TripPlanViewHolder
import java.util.*


/**
 * 일정화면 날짜별 일정 리스트
 * @author mjkim
 * @since  2021.05.12
 */
class TripPlanAdapter : RecyclerView.Adapter<TripPlanViewHolder>() {

    private var items: ArrayList<String> = arrayListOf()

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