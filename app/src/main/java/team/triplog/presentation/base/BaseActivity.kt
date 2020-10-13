package team.triplog.presentation.base

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

open class BaseActivity : AppCompatActivity() {

    private var imm: InputMethodManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    fun hideKeyboard(view: View) {
        // inputMethodManager 로 키보드를 내리도록 설정
        imm?.hideSoftInputFromWindow(view.windowToken, 0)
    }
}