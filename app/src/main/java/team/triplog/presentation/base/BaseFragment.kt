package team.triplog.presentation.base

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import team.triplog.R
import team.triplog.presentation.util.event.EventObserver
import team.triplog.presentation.viewmodel.ToolbarViewModel


/**
 * @author mjkim
 * @since  2021.05.02
 */
abstract class BaseFragment<T : ViewDataBinding>(
    @LayoutRes val layoutResId: Int
) : Fragment() {

    protected lateinit var binding: T
    protected val toolbarViewModel: ToolbarViewModel by sharedViewModel()
    protected var currentFocus: EditText? = null
    protected var hasData: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        setupToolbar()
        setup()
    }

    abstract fun setup()

    private fun setupToolbar() {
        toolbarViewModel.eventClickBack.observe(
            viewLifecycleOwner, EventObserver {
                if (!findNavController().popBackStack()) {
                    when (hasData) {
                        true -> showInitDataAlert()
                        else -> activity?.finish()
                    }
                }
            }
        )
    }

    protected fun setTitle(title: String = "") {
        toolbarViewModel.title.value = title
    }

    protected fun setSettingButton(set: Boolean) {
        toolbarViewModel.hasSetting.value = set
    }

    protected fun showToast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    protected fun showAlert(
        message: String,
        title: String? = null,
        positive: String? = null,
        negative: String? = null,
        positiveAction: ((DialogInterface, Int) -> Unit)? = null,
        negativeAction: ((DialogInterface, Int) -> Unit)? = null
    ) {
        context?.let {
            AlertDialog.Builder(it).apply {
                setMessage(message)
                title?.let { title -> setTitle(title) }
                positive?.let { positive -> setPositiveButton(positive, positiveAction) }
                negative?.let { negative -> setNegativeButton(negative, negativeAction) }
            }.show()
        }
    }

    private fun showInitDataAlert() {
        showAlert(
            message = getString(R.string.dialog_init_setting_info),
            positive = getString(R.string.button_yes),
            negative = getString(R.string.button_no),
            positiveAction = { _, _ ->
                activity?.finish()
            }
        )
    }

    protected fun showNeedPermissionAlert(permission: String) {
        showAlert(
            message = getString(R.string.dialog_need_permission, permission),
            positive = getString(R.string.button_go_device_setting),
            negative = getString(R.string.button_cancel),
            positiveAction = { _, _ -> moveAppPermission() }
        )
    }

    private fun moveAppPermission() {
        startActivity(
            Intent(
                Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.parse("package:${activity?.packageName}")
            ).apply {
                addCategory(Intent.CATEGORY_DEFAULT)
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
        )
    }
}