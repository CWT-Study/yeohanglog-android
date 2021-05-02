package team.triplog.presentation.trip.plan.fragment

import team.triplog.R
import team.triplog.databinding.FragmentTripPlanMemberBinding
import team.triplog.presentation.base.BaseFragment


/**
 * @author mjkim
 * @since  2021.05.02
 */
class TripPlanMemberFragment :
    BaseFragment<FragmentTripPlanMemberBinding>(R.layout.fragment_trip_plan_member) {

    override fun setup() {
        setViewModel()
    }

    private fun setViewModel() {
        // TODO : ViewModel 초기화
    }
}