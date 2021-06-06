package team.triplog.presentation.main.fragment

import androidx.viewpager.widget.PagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import team.triplog.R
import team.triplog.databinding.FragmentMainTripBinding
import team.triplog.presentation.base.BaseFragment
import team.triplog.presentation.main.adapter.MainTripAdapter
import team.triplog.presentation.trip.plan.activity.startTripPlanActivity
import team.triplog.presentation.util.event.EventObserver
import team.triplog.presentation.util.extension.setupButton
import team.triplog.presentation.viewmodel.TripViewModel


/**
 * @author mjkim
 * @since 2021/06/06
 **/
class MainTripFragment : BaseFragment<FragmentMainTripBinding>(
    R.layout.fragment_main_trip
) {
    private val tripViewModel: TripViewModel by sharedViewModel()

    override fun setup() {
        setupViewModel()
        setupViewpager()
        setupView()
    }

    private fun setupViewModel() {
        binding.viewModel = tripViewModel

        /** 새로운 여행 등록 클릭 */
        tripViewModel.clickCreateTrip.observe(
            viewLifecycleOwner, EventObserver {
                moveCreatePlan()
            }
        )
    }

    private fun setupViewpager() {
        val adapter: PagerAdapter = MainTripAdapter(
            activity?.supportFragmentManager,
            binding.tlMainTrip.tabCount
        )

        binding.viewpager.adapter = adapter
        binding.viewpager.addOnPageChangeListener(TabLayoutOnPageChangeListener(binding.tlMainTrip))
        binding.tlMainTrip.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab) {}
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabSelected(tab: TabLayout.Tab) {
                binding.viewpager.currentItem = tab.position
            }
        })
    }

    private fun setupView() {
        binding.ivPlus.setupButton()
    }

    private fun moveCreatePlan() {
        binding.root.context.startTripPlanActivity()
    }

    override fun onResume() {
        super.onResume()
        setTitle(getString(R.string.main_trip))
    }
}