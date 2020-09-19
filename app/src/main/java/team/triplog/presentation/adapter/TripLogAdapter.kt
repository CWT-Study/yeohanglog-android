package team.triplog.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_trip_check.view.*
import kotlinx.android.synthetic.main.item_trip_log.view.*
import team.triplog.R
import team.triplog.domain.model.TripLog
import java.util.ArrayList

class TripLogAdapter (
    private val context: Context,
    private val tripLogs: ArrayList<TripLog>
) : RecyclerView.Adapter<TripLogAdapter.ViewHolder>() {

    override fun getItemCount(): Int = tripLogs.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripLogAdapter.ViewHolder {
        return TripLogAdapter.ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_trip_log, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TripLogAdapter.ViewHolder, position: Int) {
        val item = tripLogs[position]

        if (position == 0) {
            holder.view_trip_log_image.setBackgroundResource(R.drawable.button_plus);
            holder.view_trip_log_delee.visibility = View.GONE
            return;
        }

        holder.textView.text = item.title
        holder.view_trip_log_image.setBackgroundResource(item.drawbleId)
    }




    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textView = view.text
        var view_trip_log_image = view.view_trip_log_image
        var view_trip_log_delee = view.view_trip_log_delee
    }

}