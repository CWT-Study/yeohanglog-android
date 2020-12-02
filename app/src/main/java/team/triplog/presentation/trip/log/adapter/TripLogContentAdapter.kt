package team.triplog.presentation.trip.log.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_trip_log.view.*
import kotlinx.android.synthetic.main.item_trip_log_content.view.*
import team.triplog.R
import team.triplog.domain.model.TripLog
import java.util.*

class TripLogContentAdapter (
    private val context: Context,
    private val tripLogs: ArrayList<TripLog>
) : RecyclerView.Adapter<TripLogContentAdapter.ViewHolder>() {

    override fun getItemCount(): Int = tripLogs.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_trip_log_content, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = tripLogs[position]


//        itemView.setOnClickListener(android.view.View.OnClickListener (
//            {
//                    view:android.view.View? ->   var pos: Int = getAdapterPosition()
//                if (pos != RecyclerView.NO_POSITION) {
//                    //아이템을 추가할건지 협의 필요
////                    if (pos == 0) {
////                        Toast.makeText(context, "새로운 아이템 등록", Toast.LENGTH_SHORT).show();
////                        Intent intent = new Intent(context, TripLogInfoActivity.class);
////                        context.startActivity(intent);
////                    } else {
//                    Toast.makeText(context, "기존 아이템", Toast.LENGTH_SHORT).show()
////                    }
//                }
//            }))
    }




    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textView = view.text
        var view_trip_log_image = view.view_trip_log_image
        var view_trip_log_delee = view.view_trip_log_delee

        var text_prev_year = view.text_trip_start_year
        var text_next_year = view.text_trip_end_year
        var text_prev_month = view.text_trip_start_month
        var text_next_month = view.text_trip_end_month
        var text_prev_day = view.text_trip_start_day
        var text_next_day = view.text_trip_end_day
        var text_title =view.text_trip_name
        var viewTrip = view.view_trip


    }

}