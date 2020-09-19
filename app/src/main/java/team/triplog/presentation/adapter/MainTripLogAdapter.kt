package team.triplog.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import team.triplog.R
import team.triplog.domain.model.TripLog
import team.triplog.presentation.fragment.MainTripLogFragment
import java.util.*

class MainTripLogAdapter(
    private val context: Context?,
    private val tripLogs: ArrayList<TripLog>,
    private val onClickListener: View.OnClickListener
) : RecyclerView.Adapter<MainTripLogAdapter.ViewHolder>() {

    override fun getItemCount(): Int { return tripLogs.size }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainTripLogAdapter.ViewHolder {
        return MainTripLogAdapter.ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_main_trip_log, parent, false)
        )
    }



    override fun onBindViewHolder(holder:  MainTripLogAdapter.ViewHolder, position: Int) {
        val tripLog = tripLogs[position]
        val isAdd = position == itemCount - 1
        if (isAdd) {
            holder.viewGroupImage.setBackgroundResource(R.drawable.button_plus)
            holder.textGroupName.visibility = View.INVISIBLE
        } else {
            holder.textGroupName.text = tripLog.title
            //            holder.viewGroupImage.setClipToOutline(true);
//            holder.viewGroupImage.setBackgroundResource(tripLog.drawbleId);
        }
        holder.layoutMain.tag = tripLog
        holder.layoutMain.setOnClickListener(onClickListener)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textGroupName: TextView
        var viewGroupImage: View
        var layoutMain: ConstraintLayout

        init {
            textGroupName = view.findViewById(R.id.text_group_name)
            viewGroupImage = view.findViewById(R.id.view_group_image)
            layoutMain = view.findViewById(R.id.layout_main)
        }
    }

}