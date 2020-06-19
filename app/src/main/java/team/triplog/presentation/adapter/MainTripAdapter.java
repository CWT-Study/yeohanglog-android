package team.triplog.presentation.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import team.triplog.presentation.fragment.MainTripLogFragment;
import team.triplog.presentation.fragment.MainTripPlanFragment;

public class MainTripAdapter extends FragmentStatePagerAdapter {

    int tabCount;

    MainTripAdapter(FragmentManager fm, int tabCount) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MainTripPlanFragment();
            case 1:
                return new MainTripLogFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}