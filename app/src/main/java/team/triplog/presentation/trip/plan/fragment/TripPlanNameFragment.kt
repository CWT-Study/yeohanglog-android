package team.triplog.presentation.trip.plan.fragment

import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel
import team.triplog.R
import team.triplog.databinding.FragmentTripPlanNameBinding
import team.triplog.presentation.base.BaseFragment
import team.triplog.presentation.util.extension.hideKeyboard
import team.triplog.presentation.util.extension.setupButton
import team.triplog.presentation.util.extension.showKeyboard
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

        tripPlanInfoViewModel.hasName.observe(viewLifecycleOwner, Observer {
            binding.groupTripName.isVisible = !it
            binding.groupTripPeriod.isVisible = it
            when (it) {
                true -> binding.tietTripName.hideKeyboard()
                else -> binding.tietTripName.showKeyboard()
            }
        })
    }

    private fun setView() {
        binding.clMain.setOnClickListener {
            binding.tietTripName.hideKeyboard()
        }

        binding.clNext.setupButton()
        binding.clNext.setOnClickListener {
            tripPlanInfoViewModel.setName(true)
        }
    }

    private fun checkExit() {
        if (tripPlanInfoViewModel.checkHasData()) {
            showAlert(
                message = getString(R.string.trip_plan_dialog_message),
                positive = getString(R.string.button_yes),
                negative = getString(R.string.button_no),
                positiveAction = { _, _ ->
                    activity?.finish()
                }
            )
        } else {
            activity?.finish()
        }
    }
}