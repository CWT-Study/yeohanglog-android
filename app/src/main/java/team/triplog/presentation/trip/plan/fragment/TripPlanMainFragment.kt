package team.triplog.presentation.trip.plan.fragment

import androidx.navigation.fragment.findNavController
import team.triplog.R
import team.triplog.databinding.FragmentTripPlanMainBinding
import team.triplog.presentation.base.BaseFragment
import team.triplog.presentation.trip.plan.adapter.TripPlanDayAdapter


/**
 * @author mjkim
 * @since  2021.05.02
 */
class TripPlanMainFragment :
    BaseFragment<FragmentTripPlanMainBinding>(R.layout.fragment_trip_plan_main) {

    private val planDayAdapter: TripPlanDayAdapter by lazy {
        TripPlanDayAdapter()
    }

    override fun setup() {
        setViewModel()
        setRecyclerView()
        setView()
    }

    private fun setViewModel() {
        // TODO : ViewModel 초기화
    }

    private fun setRecyclerView() {
        binding.recyclerTripPlan.adapter = planDayAdapter
    }

    private fun setView() {
        binding.flBack.setOnClickListener {
            if (!findNavController().popBackStack()) {
                activity?.finish()
            }
        }
    }
}