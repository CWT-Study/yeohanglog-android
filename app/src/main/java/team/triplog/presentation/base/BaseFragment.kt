package team.triplog.presentation.base

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {

    fun showAlert(
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