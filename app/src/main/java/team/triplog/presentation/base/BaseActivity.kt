package team.triplog.presentation.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import team.triplog.presentation.viewmodel.ToolbarViewModel


/**
 * @author  mjkim
 * @version 1.1.0
 * @since   2021.05.02
 */
abstract class BaseActivity<T : ViewDataBinding>(
    @LayoutRes val layoutResId: Int
) : AppCompatActivity() {

    protected lateinit var binding: T
    protected val toolbarViewModel: ToolbarViewModel by viewModel()
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutResId)
        binding.lifecycleOwner = this
        setup()
    }

    override fun onBackPressed() {
        if (!navController.popBackStack()) {
            super.onBackPressed()
        }
    }

    abstract fun setup()

    protected fun setupNavController(id: Int) {
        navController = supportFragmentManager.findFragmentById(id).let { fragment ->
            (fragment as NavHostFragment).navController
        }
    }

    protected fun moveFragment(action: Int) {
        navController.navigate(action)
    }

    protected fun moveTap(action: Int) {
        navController.currentDestination?.id?.let { navController.popBackStack(it, true) }
        navController.navigate(action)
    }

    protected fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}