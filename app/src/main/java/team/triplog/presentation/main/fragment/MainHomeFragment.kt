package team.triplog.presentation.main.fragment

import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import team.triplog.R
import team.triplog.data.source.local.entity.TripEntity
import team.triplog.databinding.FragmentMainHomeBinding
import team.triplog.presentation.base.BaseFragment
import team.triplog.presentation.main.adapter.MainHomeAdapter
import team.triplog.presentation.trip.plan.activity.startTripPlanActivity
import team.triplog.presentation.util.extension.setupButton
import team.triplog.presentation.viewmodel.MainViewModel
import team.triplog.presentation.viewmodel.TripLogViewModel
import team.triplog.presentation.viewmodel.TripPlanViewModel
import team.triplog.presentation.viewmodel.UserViewModel


/**
 * @author mjkim
 * @since  2021.05.02
 */
class MainHomeFragment :
    BaseFragment<FragmentMainHomeBinding>(R.layout.fragment_main_home),
    MainHomeAdapter.OnItemClickListener {

    private val mainViewModel: MainViewModel by sharedViewModel()
    private val userViewModel: UserViewModel by viewModel()
    private val tripPlanViewModel: TripPlanViewModel by viewModel()
    private val tripLogViewModel: TripLogViewModel by viewModel()

    private val mainHomeAdapter: MainHomeAdapter by lazy {
        MainHomeAdapter(this)
    }

    override fun setup() {
        setViewModel()
        setRecyclerView()
        setupView()

        // TODO : TEST CODE
        tripLogViewModel.updateTripLogList()
    }

    private fun setViewModel() {
        binding.mainViewModel = mainViewModel
        binding.userViewModel = userViewModel
        binding.tripPlanViewModel = tripPlanViewModel
        binding.tripLogViewModel = tripLogViewModel

        tripPlanViewModel.eventClickTripButton.observe(viewLifecycleOwner, Observer { trip ->
            binding.root.context.startTripPlanActivity(trip?.id)
        })
    }

    private fun setRecyclerView() {
        binding.recyclerLookBack.adapter = mainHomeAdapter
    }

    private fun setupView() {
        binding.layoutTrip.setupButton()
    }

    /**
     * 톺아보기 메뉴 아이템 클릭
     */
    override fun onItemClick(item: TripEntity) {
        // TODO : 아이템 클릭시 화면 출력
    }
}