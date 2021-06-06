package team.triplog.presentation.trip.add.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import team.triplog.presentation.trip.add.viewholder.TripAlbumViewHolder
import java.util.*


/**
 * @author mjkim
 * @since 2021/06/06
 **/
class TripAlbumAdapter(
    private val context: Context,
    private var items: ArrayList<String>,
    private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<TripAlbumViewHolder>() {
    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripAlbumViewHolder {
        return TripAlbumViewHolder.getViewHolder(parent)
    }

    override fun onBindViewHolder(holder: TripAlbumViewHolder, position: Int) {
        val item = items[position]

        holder.bind(context, item, onItemClickListener)

    }

    fun setItems(items: ArrayList<String>) {
        this.items = items
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        // TODO : 현재는 item 값을 String 으로 받고있지만, 추후 사진 관련 정보를 담는 model 로 치환 예정.
        fun onItemClick(item: String)
    }
}