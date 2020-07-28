package team.triplog.presentation.activity

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import io.realm.Realm

open class BaseActivity : AppCompatActivity() {
    var realm: Realm? = null
    private var imm: InputMethodManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        realm = Realm.getDefaultInstance()
        imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    }

    override fun onDestroy() {
        super.onDestroy()
        realm?.close()
    }

    fun hideKeyboard(view: View) {
        // inputMethodManager 로 키보드를 내리도록 설정
        imm?.hideSoftInputFromWindow(view.windowToken, 0)
    }
}