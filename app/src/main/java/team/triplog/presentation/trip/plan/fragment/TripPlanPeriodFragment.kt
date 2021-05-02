package team.triplog.presentation.trip.plan.fragment

import androidx.navigation.fragment.findNavController
import team.triplog.R
import team.triplog.databinding.FragmentTripPlanPeriodBinding
import team.triplog.presentation.base.BaseFragment


/**
 * @author mjkim
 * @since  2021.05.02
 */
class TripPlanPeriodFragment :
    BaseFragment<FragmentTripPlanPeriodBinding>(R.layout.fragment_trip_plan_period) {

    override fun setup() {
        setViewModel()
        setView()
    }

    private fun setViewModel() {
        // TODO : ViewModel 초기화
    }

    private fun setView() {
        binding.flBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_tripPlanPeriodFragment_to_tripPlanMainFragment)
        }
    }
}