package team.triplog.presentation.trip.plan.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import team.triplog.databinding.FragmentTripPlanCostBinding
import team.triplog.presentation.base.BaseFragment


/**
 * Created by Minjae Kim on 2020.12.14.

 * DESC : 여행 비용 관리 화면
 */
class TripPlanCostFragment : BaseFragment() {
    private lateinit var binding: FragmentTripPlanCostBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentTripPlanCostBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    private fun setup() {
        setViewModel()
    }

    private fun setViewModel() {
        // TODO : ViewModel 초기화
    }
}