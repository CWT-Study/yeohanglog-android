package team.triplog.presentation.util.launcher

import android.os.Build
import androidx.activity.result.contract.ActivityResultContracts


/**
 * @author mjkim
 * @since 2021/06/17
 **/
class MultiPermissionLauncher :
    BaseLauncher<Array<String>, Map<String, Boolean>>(ActivityResultContracts.RequestMultiplePermissions()) {

    var denied: (List<String>) -> Unit = {}
    var explained: (List<String>) -> Unit = {}
    var allGranted: () -> Unit = {}


    fun launch(
        permissions: Array<String>,
        allGranted: () -> Unit = {},
        denied: (List<String>) -> Unit = {},
        explained: (List<String>) -> Unit = {}
    ) {
        this.denied = denied
        this.explained = explained
        this.allGranted = allGranted

        launcher.launch(permissions)
    }

    override fun onActivityResult(result: Map<String, Boolean>?) {
        val deniedList = result?.filter { !it.value }?.map { it.key }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            when {
                !deniedList.isNullOrEmpty() -> {
                    val map = deniedList.groupBy { permission ->
                        if (activity?.shouldShowRequestPermissionRationale(permission) == true) DENIED else EXPLAINED
                    }
                    map[DENIED]?.let { denied.invoke(it) }
                    map[EXPLAINED]?.let { explained.invoke(it) }
                }
                else -> allGranted.invoke()
            }
        } else {
            allGranted.invoke()
        }

    }

    companion object {
        const val DENIED = "DENIED"
        const val EXPLAINED = "EXPLAINED"
    }
}