package team.triplog.presentation.main.fragment

import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import team.triplog.R
import team.triplog.databinding.FragmentMainProfileBinding
import team.triplog.presentation.base.BaseFragment
import team.triplog.presentation.viewmodel.UserViewModel

class MainProfileFragment : BaseFragment<FragmentMainProfileBinding>(
    R.layout.fragment_main_profile
) {
    private val userViewModel: UserViewModel by sharedViewModel()

    override fun setup() {
        setupViewModel()
        setupView()
    }

    private fun setupViewModel() {
        binding.userViewModel = userViewModel
    }

    private fun setupView() {
//        binding.textVersion.text = getString(R.string.main_more_version, BuildConfig.VERSION_NAME)
    }

    override fun onResume() {
        super.onResume()
        setTitle(getString(R.string.main_profile))
    }
}