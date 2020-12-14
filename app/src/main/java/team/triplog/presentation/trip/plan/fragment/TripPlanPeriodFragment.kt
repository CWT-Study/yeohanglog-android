package team.triplog.presentation.trip.plan.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import team.triplog.R
import team.triplog.databinding.FragmentTripPlanPeriodBinding
import team.triplog.presentation.base.BaseFragment


/**
 * Created by Minjae Kim on 2020.12.14.

 * DESC : 여행 기간 설정 화면
 */
class TripPlanPeriodFragment : BaseFragment() {
    private lateinit var binding: FragmentTripPlanPeriodBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentTripPlanPeriodBinding.inflate(inflater, container, false)
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
        binding.flBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_tripPlanPeriodFragment_to_tripPlanMainFragment)
        }
    }
}