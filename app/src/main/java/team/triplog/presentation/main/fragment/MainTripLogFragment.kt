package team.triplog.presentation.main.fragment

import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import team.triplog.R
import team.triplog.databinding.FragmentMainTripLogBinding
import team.triplog.presentation.base.BaseFragment
import team.triplog.presentation.viewmodel.TripViewModel


/**
 * @author mjkim
 * @since 2021/06/06
 **/
class MainTripLogFragment : BaseFragment<FragmentMainTripLogBinding>(
    R.layout.fragment_main_trip_log
) {
    private val tripViewModel: TripViewModel by sharedViewModel()

    override fun setup() {
        setupViewModel()
        setupRecycler()
    }

    private fun setupViewModel() {
        binding.viewModel = tripViewModel
    }

    private fun setupRecycler() {
    }
}
