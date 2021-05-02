package team.triplog.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


/**
 * @author mjkim
 * @since  2021.05.02
 */
abstract class BaseViewModel : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    protected fun setLoading(set: Boolean) {
        _isLoading.value = set
    }
}