package team.triplog.presentation.trip.add.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_trip_check.view.*
import team.triplog.R
import java.util.*

class TripCheckAdapter(
    private val context: Context,
    private val items: ArrayList<String>
) : RecyclerView.Adapter<TripCheckAdapter.ViewHolder>() {

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_trip_check, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.checkItem.isChecked = false
        holder.textItem.text = item
        holder.textManager.text = item
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var checkItem: CheckBox = view.check_item
        var textItem: TextView = view.text_item
        var textManager: TextView = view.text_manager
    }
}
