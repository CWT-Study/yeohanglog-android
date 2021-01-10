package team.triplog.presentation.trip.plan.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import team.triplog.R
import team.triplog.databinding.FragmentTripPlanNameBinding
import team.triplog.presentation.base.BaseFragment
import team.triplog.presentation.util.extension.hideKeyboard
import team.triplog.presentation.util.extension.setupButton


/**
 * Created by Minjae Kim on 2020.12.14.

 * DESC : 여행 이름 설정 화면
 */
class TripPlanNameFragment : BaseFragment() {
    private lateinit var binding: FragmentTripPlanNameBinding

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
        // TODO : ViewModel 초기화
    }

    private fun setView() {
        binding.clMain.setOnClickListener {
            binding.tietTripName.hideKeyboard()
        }

        binding.ivEditName.setupButton()
        binding.ivEditName.setOnClickListener {
            // TODO : 이름 설정으로 변경
        }

        binding.ivClose.setupButton()
        binding.ivClose.setOnClickListener {
            activity?.finish()
        }

        binding.btnNext.setupButton()
        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_tripPlanNameFragment_to_tripPlanPeriodFragment)
        }
    }
}