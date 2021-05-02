package team.triplog.presentation.trip.plan.fragment

import team.triplog.R
import team.triplog.databinding.FragmentTripPlanAlbumBinding
import team.triplog.presentation.base.BaseFragment


/**
 * @author mjkim
 * @since  2021.05.02
 */
class TripPlanAlbumFragment :
    BaseFragment<FragmentTripPlanAlbumBinding>(R.layout.fragment_trip_plan_album) {

    override fun setup() {
        setViewModel()
    }

    private fun setViewModel() {
        // TODO : ViewModel 초기화
    }
}