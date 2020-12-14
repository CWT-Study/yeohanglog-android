package team.triplog.presentation.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import team.triplog.data.source.local.entity.Trip
import team.triplog.databinding.FragmentMainHomeBinding
import team.triplog.presentation.main.adapter.MainHomeAdapter
import team.triplog.presentation.main.viewmodel.MainViewModel
import team.triplog.presentation.main.viewmodel.TripLogViewModel
import team.triplog.presentation.main.viewmodel.TripPlanViewModel
import team.triplog.presentation.main.viewmodel.UserViewModel
import team.triplog.presentation.trip.plan.activity.startTripPlanActivity

class MainHomeFragment : Fragment(), MainHomeAdapter.OnItemClickListener {
    private lateinit var binding: FragmentMainHomeBinding

    private val mainViewModel: MainViewModel by sharedViewModel()
    private val userViewModel: UserViewModel by viewModel()
    private val tripPlanViewModel: TripPlanViewModel by viewModel()
    private val tripLogViewModel: TripLogViewModel by viewModel()

    private val mainHomeAdapter: MainHomeAdapter by lazy {
        MainHomeAdapter(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainHomeBinding.inflate(inflater, container, false)
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

    /**
     * 톺아보기 메뉴 아이템 클릭
     */
    override fun onItemClick(item: Trip) {
        // TODO : 아이템 클릭시 화면 출력
    }
}