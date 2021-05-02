package team.triplog.presentation.main

import android.app.Activity
import android.content.Intent
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import org.koin.androidx.viewmodel.ext.android.viewModel
import team.triplog.R
import team.triplog.databinding.ActivityMainBinding
import team.triplog.presentation.base.BaseActivity
import team.triplog.presentation.viewmodel.MainViewModel


/**
 * @author  mjkim
 * @version 1.0.0
 * @since   2021.05.02
 */
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val viewModel: MainViewModel by viewModel()

    override fun setup() {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_main) as NavHostFragment

        binding.bottomNavigation.apply {
            setupWithNavController(navHostFragment.navController)
        }

        setViewModel()
    }

    private fun setViewModel() {
        binding.viewModel = viewModel
    }
}

fun Activity.startMainActivity() {
    startActivity(Intent(this, MainActivity::class.java))
    this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
}