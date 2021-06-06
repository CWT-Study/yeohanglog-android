package team.triplog.presentation.main.adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import team.triplog.data.source.local.entity.TripLogEntity
import team.triplog.presentation.main.viewholder.MainTripLogViewHolder


/**
 * @author mjkim
 * @since 2021/06/06
 **/
class MainTripLogAdapter : RecyclerView.Adapter<MainTripLogViewHolder>() {

    private var items: List<TripLogEntity> = listOf()
    var listener: OnItemClickListener? = null

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainTripLogViewHolder {
        return MainTripLogViewHolder.getViewHolder(parent)
    }

    override fun onBindViewHolder(holder: MainTripLogViewHolder, position: Int) {
        val item = items[position]
        val isAdd = position == itemCount - 1

        holder.bind(item, isAdd, listener)
    }

    interface OnItemClickListener {
        fun onItemClick(item: TripLogEntity)
    }

    @SuppressLint("CheckResult")
    fun setTripLogItems(tripLogItems: List<TripLogEntity>) {
        Observable.just(tripLogItems)
            .subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(Schedulers.io())
            .map { DiffUtil.calculateDiff(MainTripLogDiffCallback(this.items, tripLogItems)) }
            .subscribe({
                this.items = tripLogItems
                it.dispatchUpdatesTo(this)
            }, {

            }
            )

        notifyDataSetChanged()
    }

}