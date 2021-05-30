package team.triplog.presentation.main.fragment

import android.view.View
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import team.triplog.R
import team.triplog.databinding.FragmentMainTripPlanBinding
import team.triplog.domain.model.Trip
import team.triplog.presentation.base.BaseFragment
import team.triplog.presentation.main.adapter.MainTripPlanAdapter
import team.triplog.presentation.trip.plan.activity.startTripPlanActivity
import team.triplog.presentation.viewmodel.TripViewModel

class MainTripPlanFragment : BaseFragment<FragmentMainTripPlanBinding>(
    R.layout.fragment_main_trip_plan
), MainTripPlanAdapter.OnItemClickListener {

    private val tripViewModel: TripViewModel by sharedViewModel()
    private val mainTripPlanAdapter: MainTripPlanAdapter by lazy {
        MainTripPlanAdapter(this)
    }

    override fun setup() {
        setupViewModel()
        setupRecycler()
    }

    private fun setupViewModel() {
        binding.viewModel = tripViewModel
    }

    private fun setupRecycler() {
        binding.recyclerTripPlan.adapter = mainTripPlanAdapter
    }

    override fun onItemClick(view: View, item: Trip) {
        binding.root.context.startTripPlanActivity()
    }
}