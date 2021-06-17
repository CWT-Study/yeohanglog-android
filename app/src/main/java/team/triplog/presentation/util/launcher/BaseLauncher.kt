package team.triplog.presentation.util.launcher

import android.app.Activity
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner


/**
 * @author mjkim
 * @since 2021/06/17
 **/
abstract class BaseLauncher<I, O>(
    private val contract: ActivityResultContract<I, O>
) : DefaultLifecycleObserver, ActivityResultCallback<O> {

    lateinit var launcher: ActivityResultLauncher<I>
    var activity: Activity? = null

    @CallSuper
    override fun onCreate(owner: LifecycleOwner) {
        when (owner) {
            is ComponentActivity -> {
                activity = owner
                launcher = owner.registerForActivityResult(contract, this)
            }
            is Fragment -> {
                activity = owner.activity
                launcher = owner.registerForActivityResult(contract, this)
            }
        }
    }

    override fun onActivityResult(result: O?) {}
}