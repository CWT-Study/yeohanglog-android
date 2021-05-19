package team.triplog.presentation.trip.plan.fragment

import org.koin.androidx.viewmodel.ext.android.viewModel
import team.triplog.R
import team.triplog.databinding.FragmentTripPlanNameBinding
import team.triplog.presentation.base.BaseFragment
import team.triplog.presentation.util.event.EventObserver
import team.triplog.presentation.util.extension.hideKeyboard
import team.triplog.presentation.util.extension.setupButton
import team.triplog.presentation.viewmodel.TripPlanInfoViewModel


/**
 * @author mjkim
 * @since  2021.05.02
 */
class TripPlanNameFragment : BaseFragment<FragmentTripPlanNameBinding>(
    R.layout.fragment_trip_plan_name
) {
    private val tripPlanInfoViewModel: TripPlanInfoViewModel by viewModel()

    override fun setup() {
        setViewModel()
        setView()
    }

    private fun setViewModel() {
        binding.viewModel = tripPlanInfoViewModel

        tripPlanInfoViewModel.eventClickBackground.observe(
            viewLifecycleOwner, EventObserver {
                binding.tietTripName.hideKeyboard()
            }
        )
    }

    private fun setView() {
        binding.clNext.setupButton()
    }
}