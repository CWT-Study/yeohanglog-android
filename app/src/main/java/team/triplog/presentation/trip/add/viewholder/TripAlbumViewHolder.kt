package team.triplog.presentation.trip.add.viewholder

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import team.triplog.databinding.ItemTripAlbumBinding
import team.triplog.presentation.trip.add.adapter.TripAlbumAdapter


/**
 * @author mjkim
 * @since 2021/06/06
 **/
class TripAlbumViewHolder(
    private val binding: ItemTripAlbumBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun getViewHolder(parent: ViewGroup): TripAlbumViewHolder {
            val binding =
                ItemTripAlbumBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return TripAlbumViewHolder(binding)
        }
    }

    fun bind(
        context: Context,
        item: String,
        itemClickListener: TripAlbumAdapter.OnItemClickListener
    ) {
        Glide.with(context)
            .load(item)
            .thumbnail(0.1f)
            .into(binding.viewAlbum)

        binding.viewAlbum.setOnClickListener {
            itemClickListener.onItemClick(item)
        }
    }
}