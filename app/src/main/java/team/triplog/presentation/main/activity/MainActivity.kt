package team.triplog.presentation.main.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import team.triplog.R
import team.triplog.databinding.ActivityMainBinding
import team.triplog.presentation.base.BaseActivity
import team.triplog.presentation.fragment.MainSearchFragment
import team.triplog.presentation.fragment.MainTripFragment
import team.triplog.presentation.main.fragment.MainHomeFragment
import team.triplog.presentation.main.fragment.MainMoreFragment
import team.triplog.presentation.main.viewmodel.MainViewModel


class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            lifecycleOwner = this@MainActivity
            viewModel = this@MainActivity.viewModel
        }

        init()
        addObservableData()
    }

    private fun init() {
        bottom_navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    private fun addObservableData() {
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
                R.id.navigation_more -> fragmentChange(MainMoreFragment(viewModel.readUser("").value))
            }
            false
        }
}

