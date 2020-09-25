package team.triplog.presentation.main.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import team.triplog.R
import team.triplog.databinding.ActivityMainBinding
import team.triplog.presentation.base.BaseActivity
import team.triplog.presentation.main.viewmodel.MainViewModel


class MainActivity : BaseActivity() {
    private val binding by binding<ActivityMainBinding>(R.layout.activity_main)

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            lifecycleOwner = this@MainActivity
            viewModel = this@MainActivity.viewModel
        }

        addObservableData()
    }

    private fun addObservableData() {
        bottom_navigation.setOnNavigationItemSelectedListener(viewModel.onNavigationItemSelectedListener)

        viewModel.fragment.observe(this) {
            fragmentChange(viewModel.fragment.value)
        }
    }

    private fun fragmentChange(fragment: Fragment?) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_main, fragment!!)
        fragmentTransaction.commit()
    }
}

