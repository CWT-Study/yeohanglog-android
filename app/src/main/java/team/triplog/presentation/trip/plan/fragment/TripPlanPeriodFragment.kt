package team.triplog.presentation.trip.plan.fragment

import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import team.triplog.R
import team.triplog.databinding.FragmentTripPlanPeriodBinding
import team.triplog.presentation.base.BaseFragment
import team.triplog.presentation.util.event.EventObserver
import team.triplog.presentation.viewmodel.TripPlanInfoViewModel


/**
 * @author mjkim
 * @since  2021.05.02
 */
class TripPlanPeriodFragment : BaseFragment<FragmentTripPlanPeriodBinding>(
    R.layout.fragment_trip_plan_period
) {
    private val tripPlanInfoViewModel: TripPlanInfoViewModel by sharedViewModel()

    override fun setup() {
        setViewModel()
        setCalendar()
    }

    private fun setViewModel() {
        binding.viewModel = tripPlanInfoViewModel

        tripPlanInfoViewModel.eventClickNext.observe(
            viewLifecycleOwner, EventObserver {
                moveMain()
            }
        )

        tripPlanInfoViewModel.eventClickDate.observe(
            viewLifecycleOwner, EventObserver {
            }
        )
    }

    private fun setCalendar() {
    }

    private fun moveMain() {
        findNavController().navigate(
            R.id.action_tripPlanPeriodFragment_to_tripPlanMainFragment
        )
    }
}