package team.triplog.presentation.trip.plan.fragment

import team.triplog.R
import team.triplog.databinding.FragmentTripPlanCheckBinding
import team.triplog.presentation.base.BaseFragment


/**
 * @author mjkim
 * @since  2021.05.02
 */
class TripPlanCheckFragment : BaseFragment<FragmentTripPlanCheckBinding>(
    R.layout.fragment_trip_plan_check
) {
    override fun setup() {
        setViewModel()
    }

    private fun setViewModel() {
        // TODO : ViewModel 초기화
    }
}