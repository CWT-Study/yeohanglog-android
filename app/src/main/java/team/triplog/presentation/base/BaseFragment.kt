package team.triplog.presentation.base

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment


/**
 * @author mjkim
 * @since  2021.05.02
 */
abstract class BaseFragment<T : ViewDataBinding>(
    @LayoutRes val layoutResId: Int
) : Fragment() {
    lateinit var binding: T

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
        setup()
    }

    abstract fun setup()

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
}