package team.triplog.presentation.trip.plan.fragment

import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
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
    private val tripPlanInfoViewModel: TripPlanInfoViewModel by sharedViewModel()

    override fun setup() {
        setViewModel()
        setView()
    }

    private fun setViewModel() {
        binding.viewModel = tripPlanInfoViewModel

        tripPlanInfoViewModel.eventClickBackground.observe(
            viewLifecycleOwner, EventObserver {
                currentFocus?.hideKeyboard()
            }
        )

        tripPlanInfoViewModel.eventClickNext.observe(
            viewLifecycleOwner, EventObserver {
                currentFocus?.hideKeyboard()
                movePeriod()
            }
        )

        tripPlanInfoViewModel.tripName.observe(
            viewLifecycleOwner, Observer {
                hasData = tripPlanInfoViewModel.checkHasData()
            }
        )
    }

    private fun setView() {
        binding.clNext.setupButton()
        binding.tietTripName.setOnFocusChangeListener { view, hasFocus ->
            if (hasFocus) currentFocus = view as EditText
        }
    }

    private fun movePeriod() {
        findNavController().navigate(
            R.id.action_tripPlanNameFragment_to_tripPlanPeriodFragment
        )
    }
}