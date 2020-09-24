package team.triplog.presentation.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import team.triplog.databinding.ItemTripLogInfoUserBinding
import team.triplog.domain.model.TripLogInfoChat

class TripLogInfoChatViewHolder(
    private val binding: ItemTripLogInfoUserBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun getViewHolder(parent: ViewGroup): TripLogInfoChatViewHolder {
            // TODO : item_trip_info_user 이름 변경 필요.
            val binding =
                ItemTripLogInfoUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return TripLogInfoChatViewHolder(binding)
        }
    }

    fun bind(item: TripLogInfoChat) {
        // TODO : Test Data
        binding.tripLogInfoUserName.text = "홍길동"
        item.sentence?.let {
            binding.textUserSentence.text = "문장을 입력하세요"
        } ?: run {
            binding.textUserSentence.text = item.sentence
        }
    }
}