package team.triplog.presentation.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import team.triplog.R
import team.triplog.data.local.User
import team.triplog.presentation.base.BaseActivity
import team.triplog.presentation.main.fragment.MainSearchFragment
import team.triplog.presentation.fragment.MainTripFragment
import team.triplog.presentation.main.fragment.MainHomeFragment
import team.triplog.presentation.main.fragment.MainMoreFragment

class MainActivity : BaseActivity() {
    private var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        setData()
        setUi()
    }

    private fun init() {
        bottom_navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    private fun setData() {
        // TODO : Room 으로 변경하기 위해 주석처리
//        user = realm?.where(User::class.java)?.findFirst()
    }

    private fun setUi() {
        fragmentChange(MainHomeFragment())
    }

    private fun fragmentChange(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_main, fragment)
        fragmentTransaction.commit()
    }

    private var onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem: MenuItem ->
            menuItem.isChecked = true
            when (menuItem.itemId) {
                R.id.navigation_home -> fragmentChange(MainHomeFragment())
                R.id.navigation_trip -> fragmentChange(MainTripFragment())
                R.id.navigation_search -> fragmentChange(MainSearchFragment())
                R.id.navigation_more -> fragmentChange(MainMoreFragment(user))
            }
            false
        }
}

fun Context.startMainActivity() {
    Intent(this, MainActivity::class.java).apply {
        startActivity(this)
    }
}