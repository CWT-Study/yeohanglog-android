package team.triplog.presentation.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding


/**
 * @author  mjkim
 * @version 1.0.0
 * @since   2021.05.02
 */
abstract class BaseActivity<T : ViewDataBinding>(
    @LayoutRes val layoutResId: Int
) : AppCompatActivity() {

    protected lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutResId)
        binding.lifecycleOwner = this
        setup()
    }

    abstract fun setup()

    protected fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}