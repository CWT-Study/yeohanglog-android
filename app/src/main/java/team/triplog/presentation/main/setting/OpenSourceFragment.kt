package team.triplog.presentation.main.setting

import team.triplog.R
import team.triplog.databinding.FragmentOpenSourceBinding
import team.triplog.presentation.base.BaseFragment

/**
 *  @author mjkim
 *  @since  2021.05.30
 */
class OpenSourceFragment : BaseFragment<FragmentOpenSourceBinding>(
    R.layout.fragment_open_source
) {
    override fun setup() {
        setViewModel()
    }

    private fun setViewModel() {
    }

    override fun onResume() {
        super.onResume()
        setTitle(getString(R.string.setting_open_source))
    }
}
