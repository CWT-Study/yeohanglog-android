package team.triplog.presentation.trip.log.logdetail.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import team.triplog.databinding.ItemTripLogDetailUserBinding
import team.triplog.domain.model.TripLogDetailChat

class TripLogDetailChatViewHolder(
    private val binding: ItemTripLogDetailUserBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun getViewHolder(parent: ViewGroup): TripLogDetailChatViewHolder {
            val binding =
                ItemTripLogDetailUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return TripLogDetailChatViewHolder(binding)
        }
    }

    fun bind(item: TripLogDetailChat) {
        // TODO : Test Data
        binding.tripLogDetailUserName.text = "홍길동"
        item.sentence?.let {
            binding.textUserSentence.text = "문장을 입력하세요"
        } ?: run {
            binding.textUserSentence.text = item.sentence
        }
    }
}