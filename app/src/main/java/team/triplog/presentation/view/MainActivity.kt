package team.triplog.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import team.triplog.R
import team.triplog.data.local.User
import team.triplog.databinding.ActivityMainBinding
import team.triplog.presentation.base.BaseActivity
import team.triplog.presentation.viewModel.MainViewModel


class MainActivity : BaseActivity() {
    private val binding by binding<ActivityMainBinding>(R.layout.activity_main)
    private var user: User? = null
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

        viewModel.fragment.observe(::getLifecycle) {
            fragmentChange(viewModel.fragment.value)
        }
    }

    private fun fragmentChange(fragment: Fragment?) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_main, fragment!!)
        fragmentTransaction.commit()
    }
}

