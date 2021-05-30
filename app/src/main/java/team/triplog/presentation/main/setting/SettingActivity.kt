package team.triplog.presentation.main.setting

import team.triplog.R
import team.triplog.databinding.ActivitySettingBinding
import team.triplog.presentation.base.BaseActivity
import team.triplog.presentation.util.extension.setupButton


/**
 * @author mjkim
 * @since 2021.05.30
 */
class SettingActivity : BaseActivity<ActivitySettingBinding>(
    R.layout.activity_setting
) {
    override fun setup() {
        setupNavController(R.id.fragment_setting)
        setupViewModel()
        setupView()
    }

    private fun setupViewModel() {
        binding.toolbarViewModel = toolbarViewModel
    }

    private fun setupView() {
        binding.btnBack.setupButton()
    }
}