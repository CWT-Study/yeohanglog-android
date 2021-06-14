package team.triplog.presentation.util.extension

import android.os.Build
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment

const val DENIED = "DENIED"
const val EXPLAINED = "EXPLAINED"


/**
 * 권한 요청 (Activity)
 * [permission]
 * [granted]
 * [denied]
 * [explained]
 * [belowVersionM]
 */
inline fun ComponentActivity.requestPermission(
    permission: String,
    crossinline granted: (permission: String) -> Unit = {},
    crossinline denied: (permission: String) -> Unit = {},
    crossinline explained: (permission: String) -> Unit = {},
    crossinline belowVersionM: () -> Unit = {}
): ActivityResultLauncher<String> {
    return registerForActivityResult(ActivityResultContracts.RequestPermission()) { result ->
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            when {
                result -> granted.invoke(permission)
                shouldShowRequestPermissionRationale(permission) -> denied.invoke(permission)
                else -> explained.invoke(permission)
            }
        } else belowVersionM.invoke()
    }
}

/**
 * 다수 권한 요청 (Activity)
 * [allGranted]
 * [denied]
 * [explained]
 * [belowVersionM]
 */
inline fun ComponentActivity.requestMultiplePermissions(
    crossinline allGranted: () -> Unit = {},
    crossinline denied: (List<String>) -> Unit = {},
    crossinline explained: (List<String>) -> Unit = {},
    crossinline belowVersionM: () -> Unit = {}
): ActivityResultLauncher<Array<String>> {
    return registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { result: MutableMap<String, Boolean> ->
        val deniedList = result.filter { !it.value }.map { it.key }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            when {
                deniedList.isNotEmpty() -> {
                    val map = deniedList.groupBy { permission ->
                        if (shouldShowRequestPermissionRationale(permission)) DENIED else EXPLAINED
                    }
                    map[DENIED]?.let { denied.invoke(it) }
                    map[EXPLAINED]?.let { explained.invoke(it) }
                }
                else -> allGranted.invoke()
            }
        } else belowVersionM.invoke()
    }
}

/**
 * 권한 요청 (Fragment)
 * [permission]
 * [granted]
 * [denied]
 * [explained]
 * [belowVersionM]
 */
inline fun Fragment.requestPermission(
    permission: String,
    crossinline granted: (permission: String) -> Unit = {},
    crossinline denied: (permission: String) -> Unit = {},
    crossinline explained: (permission: String) -> Unit = {},
    crossinline belowVersionM: () -> Unit = {}
): ActivityResultLauncher<String> {
    return registerForActivityResult(ActivityResultContracts.RequestPermission()) { result ->
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            when {
                result -> granted.invoke(permission)
                shouldShowRequestPermissionRationale(permission) -> denied.invoke(permission)
                else -> explained.invoke(permission)
            }
        } else belowVersionM.invoke()
    }
}

/**
 * 다수 권한 요청 (Fragment)
 * [allGranted]
 * [denied]
 * [explained]
 * [belowVersionM]
 */
inline fun Fragment.requestMultiplePermissions(
    crossinline allGranted: () -> Unit = {},
    crossinline denied: (List<String>) -> Unit = {},
    crossinline explained: (List<String>) -> Unit = {},
    crossinline belowVersionM: () -> Unit = {}
): ActivityResultLauncher<Array<String>> {
    return registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { result: MutableMap<String, Boolean> ->
        val deniedList = result.filter { !it.value }.map { it.key }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            when {
                deniedList.isNotEmpty() -> {
                    val map = deniedList.groupBy { permission ->
                        if (shouldShowRequestPermissionRationale(permission)) DENIED else EXPLAINED
                    }
                    map[DENIED]?.let { denied.invoke(it) }
                    map[EXPLAINED]?.let { explained.invoke(it) }
                }
                else -> allGranted.invoke()
            }
        } else belowVersionM.invoke()
    }
}