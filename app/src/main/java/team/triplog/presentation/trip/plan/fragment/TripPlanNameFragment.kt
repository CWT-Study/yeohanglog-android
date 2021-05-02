package team.triplog.presentation.trip.plan.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel
import team.triplog.R
import team.triplog.databinding.FragmentTripPlanNameBinding
import team.triplog.presentation.base.BaseFragment
import team.triplog.presentation.viewmodel.TripPlanInfoViewModel
import team.triplog.presentation.util.extension.hideKeyboard
import team.triplog.presentation.util.extension.setupButton
import team.triplog.presentation.util.extension.showKeyboard


/**
 * Created by Minjae Kim on 2020.12.14.

 * DESC : 여행 이름 설정 화면
 */
class TripPlanNameFragment : BaseFragment() {
    private lateinit var binding: FragmentTripPlanNameBinding

    private val tripPlanInfoViewModel: TripPlanInfoViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentTripPlanNameBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    private fun setup() {
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

        binding.ivEditName.setupButton()
        binding.ivEditName.setOnClickListener {
            tripPlanInfoViewModel.setName(false)
        }

        binding.ivClose.setupButton()
        binding.ivClose.setOnClickListener {
            checkExit()
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