package team.triplog.presentation.trip.add.activity

import android.view.MenuItem
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_trip_check.*
import team.triplog.R
import team.triplog.databinding.ActivityTripCheckBinding
import team.triplog.presentation.base.BaseActivity
import team.triplog.presentation.trip.add.adapter.TripCheckAdapter


/**
 * @author mjkim
 * @since  2021.05.02
 */
class TripCheckActivity : BaseActivity<ActivityTripCheckBinding>(R.layout.activity_trip_check) {

    private var checkAdapter: TripCheckAdapter? = null
    private val checkList = arrayListOf<String>()

    override fun setup() {
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

        initList()
    }

    private fun setData() {}

    private fun setUi() {}

    private fun initList() {
        checkAdapter = TripCheckAdapter(this, checkList)
        recycler_check.adapter = checkAdapter
        checkEmptyList()
    }

    private fun checkEmptyList() {
        binding.tvNoContents.isVisible = checkList.isEmpty()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}