package team.triplog.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import team.triplog.MainHomeFragment;
import team.triplog.MainMoreFragment;
import team.triplog.MainSearchFragment;
import team.triplog.MainTripFragment;
import team.triplog.R;

public class MainActivity extends AppCompatActivity {

    FrameLayout fragmentMain;
    BottomNavigationView bottomNavigation;

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

    }

    private void setUi() {
        fragmentChange(new MainHomeFragment());
    }

    private void fragmentChange(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_main, fragment);
        fragmentTransaction.commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem menuItem) {
                    menuItem.setChecked(true);
                    switch (menuItem.getItemId()) {
                        case R.id.navigation_home:
                            fragmentChange(new MainHomeFragment());
                            break;
                        case R.id.navigation_trip:
                            fragmentChange(new MainTripFragment());
                            break;
                        case R.id.navigation_search:
                            fragmentChange(new MainSearchFragment());
                            break;
                        case R.id.navigation_more:
                            fragmentChange(new MainMoreFragment());
                            break;
                    }
                    return false;
                }
            };
}
