package team.triplog.presentation.main.adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import team.triplog.data.local.TripLog
import team.triplog.presentation.viewholder.MainHomeViewHolder

class MainHomeAdapter() : RecyclerView.Adapter<MainHomeViewHolder>() {

    private var items: List<TripLog> = listOf()

    var listener: OnItemClickListener? = null


    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHomeViewHolder {
        return MainHomeViewHolder.getViewHolder(parent)
    }

    override fun onBindViewHolder(holder: MainHomeViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item, listener)
    }

    interface OnItemClickListener {
        fun onItemClick(item: TripLog)
    }

    @SuppressLint("CheckResult")
    fun setTripLogItems(tripLogItems: List<TripLog>){
        Observable.just(tripLogItems)
            .subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(Schedulers.io())
            .map { DiffUtil.calculateDiff(MainHomeDiffCallback(this.items,tripLogItems)) }
            .subscribe({
                this.items = tripLogItems
                it.dispatchUpdatesTo(this)
            },{

            }
            )

        notifyDataSetChanged()
    }
}