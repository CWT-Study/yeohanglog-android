package team.triplog.presentation.activity;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import team.triplog.R;
import team.triplog.data.local.User;
import team.triplog.presentation.fragment.MainHomeFragment;
import team.triplog.presentation.fragment.MainMoreFragment;
import team.triplog.presentation.fragment.MainSearchFragment;
import team.triplog.presentation.fragment.MainTripFragment;

public class MainActivity extends BaseActivity {

    FrameLayout fragmentMain;
    BottomNavigationView bottomNavigation;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setData();
        setUi();
    }

    private void init() {
        fragmentMain = findViewById(R.id.fragment_main);
        bottomNavigation = findViewById(R.id.bottom_navigation);

        bottomNavigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
    }

    private void setData() {
        user = realm.where(User.class).findFirst();
    }

    private void setUi() {
        fragmentChange(new MainHomeFragment(user));
    }

    private void fragmentChange(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_main, fragment);
        fragmentTransaction.commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener =
            menuItem -> {
                menuItem.setChecked(true);
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:
                        fragmentChange(new MainHomeFragment(user));
                        break;
                    case R.id.navigation_trip:
                        fragmentChange(new MainTripFragment());
                        break;
                    case R.id.navigation_search:
                        fragmentChange(new MainSearchFragment());
                        break;
                    case R.id.navigation_more:
                        fragmentChange(new MainMoreFragment(realm, user));
                        break;
                }
                return false;
            };
}
