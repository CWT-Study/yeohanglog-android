package team.triplog.presentation.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import team.triplog.R;
import team.triplog.presentation.activity.TripInfoActivity;
import team.triplog.presentation.adapter.MainTripAdapter;

public class MainTripFragment extends Fragment {

    private View rootView;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ConstraintLayout buttonPlus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main_trip, container, false);

        init();
        initViewpager();

        return rootView;
    }

    private void init() {
        viewPager = rootView.findViewById(R.id.viewpager);
        tabLayout = rootView.findViewById(R.id.layout_tabs);
        buttonPlus = rootView.findViewById(R.id.button_plus);

        buttonPlus.setOnClickListener(onClickListener);
    }

    private void initViewpager() {
        PagerAdapter adapter = new MainTripAdapter(getActivity().getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    private View.OnClickListener onClickListener = view -> {
        switch (view.getId()) {
            case R.id.button_plus:
                Intent intent = new Intent(getContext(), TripInfoActivity.class);
                startActivity(intent);
                break;
        }
    };
}
