package team.triplog.presentation.trip.plan.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import team.triplog.databinding.FragmentTripPlanMainBinding
import team.triplog.presentation.base.BaseFragment
import team.triplog.presentation.trip.plan.adapter.TripPlanDayAdapter


/**
 * Created by Minjae Kim on 2020.12.14.

 * DESC : 여행 계획 메인화면
 */
class TripPlanMainFragment : BaseFragment() {
    private lateinit var binding: FragmentTripPlanMainBinding

    private val planDayAdapter: TripPlanDayAdapter by lazy {
        TripPlanDayAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentTripPlanMainBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    private fun setup() {
        setViewModel()
        setRecyclerView()
        setView()
    }

    private fun setViewModel() {
        // TODO : ViewModel 초기화
    }

    private fun setRecyclerView() {
        binding.recyclerTripPlan.adapter = planDayAdapter
    }

    private fun setView() {
        binding.flBack.setOnClickListener {
            if (!findNavController().popBackStack()) {
                activity?.finish()
            }
        }
    }
}