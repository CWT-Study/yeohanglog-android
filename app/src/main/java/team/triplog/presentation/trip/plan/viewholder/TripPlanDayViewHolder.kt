package team.triplog.presentation.trip.plan.viewholder

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import team.triplog.databinding.ItemTripPlanDayBinding
import team.triplog.presentation.trip.plan.adapter.TripPlanAdapter
import java.util.*

class TripPlanDayViewHolder(
    private val binding: ItemTripPlanDayBinding
) : RecyclerView.ViewHolder(binding.root) {

    private val plans = ArrayList<String>()
    private var planAdapter: TripPlanAdapter? = null

    companion object {
        fun getViewHolder(parent: ViewGroup): TripPlanDayViewHolder {
            val binding =
                ItemTripPlanDayBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return TripPlanDayViewHolder(binding)
        }
    }

    fun bind(context: Context, item: String) {
        binding.textDay.text = item
        val layoutManager = LinearLayoutManager(context)
        planAdapter = TripPlanAdapter(context, plans)
        binding.recyclerTripPlanDay.layoutManager = layoutManager
        binding.recyclerTripPlanDay.adapter = planAdapter
        setData()
    }

    private fun setData() {
        // TODO : Test Data
        plans.clear()
        plans.add("TEST_LOCATION1")
        plans.add("TEST_LOCATION2")
        plans.add("TEST_LOCATION3")
        plans.add("TEST_LOCATION4")
        plans.add("TEST_LOCATION5")

        planAdapter?.setItems(plans)
    }
}