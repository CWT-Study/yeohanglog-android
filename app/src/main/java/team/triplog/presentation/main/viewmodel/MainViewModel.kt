package team.triplog.presentation.main.viewmodel

import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.realm.Realm
import team.triplog.R
import team.triplog.data.local.User
import team.triplog.presentation.fragment.MainHomeFragment
import team.triplog.presentation.fragment.MainMoreFragment
import team.triplog.presentation.fragment.MainSearchFragment
import team.triplog.presentation.fragment.MainTripFragment

class MainViewModel() : ViewModel() {
    var user : User? = null

     var onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem: MenuItem ->
            menuItem.isChecked = true
            when (menuItem.itemId) {
                R.id.navigation_home -> fragment.value = MainHomeFragment(user)
                R.id.navigation_trip -> fragment.value = MainTripFragment()
                R.id.navigation_search -> fragment.value = MainSearchFragment()
                R.id.navigation_more -> fragment.value = MainMoreFragment(user)
            }
            false
        }

    val fragment = MutableLiveData<Fragment>()

}