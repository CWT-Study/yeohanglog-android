package team.triplog.presentation.activity;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import io.realm.Realm;
import team.triplog.R;
import team.triplog.presentation.fragment.MainHomeFragment;
import team.triplog.presentation.fragment.MainMoreFragment;
import team.triplog.presentation.fragment.MainSearchFragment;
import team.triplog.presentation.fragment.MainTripFragment;

public class BaseActivity extends AppCompatActivity {

    protected Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        realm = Realm.getDefaultInstance();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        realm.close();
    }
}
