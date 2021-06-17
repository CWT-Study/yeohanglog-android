package team.triplog.presentation.util.launcher

import androidx.activity.result.contract.ActivityResultContracts


/**
 * @author mjkim
 * @since 2021/06/17
 **/
class PermissionLauncher :
    BaseLauncher<String, Boolean>(ActivityResultContracts.RequestPermission()) {

    var permission: String = ""
    var granted: (permission: String) -> Unit = {}
    var denied: (permission: String) -> Unit = {}
    var explained: (permission: String) -> Unit = {}

    fun launch(
        permission: String,
        granted: (String) -> Unit = {},
        denied: (String) -> Unit = {},
        explained: (String) -> Unit = {}
    ) {
        this.permission = permission
        this.granted = granted
        this.explained = explained
        this.denied = denied

        launcher.launch(permission)
    }

    override fun onActivityResult(result: Boolean?) {
        when (result) {
            true -> granted.invoke(permission)
            else -> explained.invoke(permission)
        }
    }
}