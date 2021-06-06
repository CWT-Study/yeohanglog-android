package team.triplog.presentation.trip.plan.fragment

import team.triplog.R
import team.triplog.databinding.FragmentTripPlanCostBinding
import team.triplog.presentation.base.BaseFragment
import team.triplog.presentation.util.TextCountAnimation


/**
 * @author mjkim
 * @since  2021.05.02
 */
class TripPlanCostFragment : BaseFragment<FragmentTripPlanCostBinding>(
    R.layout.fragment_trip_plan_cost
) {
    override fun setup() {
        setViewModel()
        setView()
    }

    private fun setViewModel() {
        // TODO : ViewModel 초기화
    }

    private fun setView() {
        // TODO : 텍스트 카운팅 애니메이션
//        binding.textTotal.startAnimation(TextCountAnimation(binding.textTotal, 1000))
    }
}