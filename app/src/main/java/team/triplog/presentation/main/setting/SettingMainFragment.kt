package team.triplog.presentation.main.setting

import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import team.triplog.BuildConfig
import team.triplog.R
import team.triplog.databinding.FragmentSettingMainBinding
import team.triplog.presentation.base.BaseFragment
import team.triplog.presentation.util.extension.setupButton
import team.triplog.presentation.viewmodel.SettingViewModel

/**
 *  @author mjkim
 *  @since  2021.05.30
 */
class SettingMainFragment : BaseFragment<FragmentSettingMainBinding>(
    R.layout.fragment_setting_main
) {
    private val settingViewModel: SettingViewModel by sharedViewModel()

    override fun setup() {
        setupViewModel()
        setupView()
    }

    private fun setupViewModel() {
        binding.settingViewModel = settingViewModel
    }

    private fun setupView() {
        binding.tvVersion.text = getString(R.string.setting_version, BuildConfig.VERSION_NAME)

        // TODO : include 로 사용한 view 의 onClick 처리 필요
        binding.menuOpenSource.clMain.setupButton()
        binding.menuOpenSource.clMain.setOnClickListener {
            moveMenu(SettingMenu.OPEN_SOURCE)
        }
        binding.menuTheme.clMain.setupButton()
        binding.menuTheme.clMain.setOnClickListener {
            moveMenu(SettingMenu.THEME)
        }
    }

    private fun moveMenu(menu: SettingMenu) {
        findNavController().navigate(
            when (menu) {
                SettingMenu.OPEN_SOURCE -> R.id.action_settingMainFragment_to_openSourceFragment
                SettingMenu.THEME -> R.id.action_settingMainFragment_to_themeFragment
            }
        )
    }

    override fun onResume() {
        super.onResume()
        setTitle(getString(R.string.setting_main))
    }
}
