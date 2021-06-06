package team.triplog.presentation.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import team.triplog.presentation.main.fragment.MainTripLogFragment
import team.triplog.presentation.main.fragment.MainTripPlanFragment


/**
 * @author mjkim
 * @since 2021/06/06
 **/
class MainTripAdapter(
    fm: FragmentManager?,
    var tabCount: Int
) : FragmentStatePagerAdapter(
    fm!!, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {
    override fun getCount(): Int = tabCount

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> MainTripPlanFragment()
            else -> MainTripLogFragment()
        }
    }
}