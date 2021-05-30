package team.triplog.presentation.main

import android.app.Activity
import android.content.Intent
import org.koin.androidx.viewmodel.ext.android.viewModel
import team.triplog.R
import team.triplog.databinding.ActivityMainBinding
import team.triplog.presentation.base.BaseActivity
import team.triplog.presentation.main.setting.SettingActivity
import team.triplog.presentation.util.event.EventObserver
import team.triplog.presentation.util.extension.setupButton
import team.triplog.presentation.viewmodel.MainViewModel


/**
 * @author mjkim
 * @since 2021.05.02
 */
class MainActivity : BaseActivity<ActivityMainBinding>(
    R.layout.activity_main
) {
    private val mainViewModel: MainViewModel by viewModel()

    override fun setup() {
        setupNavController(R.id.fragment_main)
        setupViewModel()
        setupView()
    }

    private fun setupViewModel() {
        binding.viewModel = mainViewModel
        binding.toolbarViewModel = toolbarViewModel

        mainViewModel.clickSetting.observe(
            this, EventObserver {
                moveSetting()
            }
        )
    }

    private fun setupView() {
        binding.btnHome.setupButton(CLICK)
        binding.btnTrip.setupButton(CLICK)
        binding.btnProfile.setupButton(CLICK)
        binding.btnSetting.setupButton()
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        binding.rgNavigation.setOnCheckedChangeListener { _, id ->
            when (id) {
                binding.btnHome.id -> moveTap(R.id.navigation_home)
                binding.btnTrip.id -> moveTap(R.id.navigation_trip)
                binding.btnProfile.id -> moveTap(R.id.navigation_profile)
            }
        }
    }

    private fun moveSetting() {
        startActivity(Intent(this, SettingActivity::class.java))
    }

    companion object {
        private const val CLICK = 0.9F
    }
}

fun Activity.startMainActivity() {
    startActivity(Intent(this, MainActivity::class.java))
    this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
}