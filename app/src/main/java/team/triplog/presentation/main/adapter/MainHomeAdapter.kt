package team.triplog.presentation.main.adapter

import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import team.triplog.data.source.local.entity.TripEntity
import team.triplog.presentation.main.viewholder.MainHomeViewHolder


/**
 * @author mjkim
 * @since 2021/06/06
 **/
class MainHomeAdapter(
    var onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<MainHomeViewHolder>() {

    private var items: List<TripEntity> = listOf()

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHomeViewHolder {
        return MainHomeViewHolder.getViewHolder(parent)
    }

    override fun onBindViewHolder(holder: MainHomeViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item, onItemClickListener)
    }

    fun updateItems(items: List<TripEntity>?) {
        this.items = items ?: listOf()
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClick(item: TripEntity)
    }
}

@BindingAdapter("tripLogList")
fun bindItems(recycler: RecyclerView, items: List<TripEntity>?) {
    val adapter = recycler.adapter as MainHomeAdapter?
    adapter?.updateItems(items)
}