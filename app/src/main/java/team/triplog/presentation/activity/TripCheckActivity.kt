package team.triplog.presentation.activity

import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_trip_check.*
import team.triplog.R

class TripCheckActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trip_check)

        init()
        setData()
        setUi()
    }

    private fun init() {
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setDisplayShowTitleEnabled(false)
        }
    }

    private fun setData() {}
    private fun setUi() {}

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}