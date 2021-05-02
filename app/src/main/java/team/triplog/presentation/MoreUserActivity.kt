package team.triplog.presentation

import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_more_user.*
import team.triplog.R
import team.triplog.databinding.ActivityMoreUserBinding
import team.triplog.presentation.base.BaseActivity


/**
 * @author  mjkim
 * @version 1.0.0
 * @since   2021.05.02
 */
class MoreUserActivity : BaseActivity<ActivityMoreUserBinding>(R.layout.activity_more_user) {

    override fun setup() {
        init()
    }

    private fun init() {
        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
            supportActionBar!!.setDisplayShowTitleEnabled(false)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}