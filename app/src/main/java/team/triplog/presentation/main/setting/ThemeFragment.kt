package team.triplog.presentation.main.setting

import team.triplog.R
import team.triplog.databinding.FragmentThemeBinding
import team.triplog.presentation.base.BaseFragment


/**
 *  @author mjkim
 *  @since  2021.05.30
 */
class ThemeFragment : BaseFragment<FragmentThemeBinding>(
    R.layout.fragment_theme
) {
    override fun setup() {
        setViewModel()
    }

    private fun setViewModel() {
    }

    override fun onResume() {
        super.onResume()
        setTitle(getString(R.string.setting_theme))
    }
}
