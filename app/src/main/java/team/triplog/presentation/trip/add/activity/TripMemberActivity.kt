package team.triplog.presentation.trip.add.activity

import android.view.MenuItem
import team.triplog.R
import team.triplog.databinding.ActivityTripMemberBinding
import team.triplog.presentation.base.BaseActivity


/**
 * @author mjkim
 * @since  2021.05.02
 */
class TripMemberActivity : BaseActivity<ActivityTripMemberBinding>(
    R.layout.activity_trip_member
) {

    override fun setup() {
        init()
        setData()
        setUi()
    }

    private fun init() {
        setSupportActionBar(binding.toolbar)
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