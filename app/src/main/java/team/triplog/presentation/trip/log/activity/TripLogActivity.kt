package team.triplog.presentation.trip.log.activity

import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_trip_log.*
import team.triplog.R
import team.triplog.databinding.ActivityTripLogBinding
import team.triplog.domain.model.TripLog
import team.triplog.presentation.base.BaseActivity
import team.triplog.presentation.trip.log.adapter.TripLogAdapter
import team.triplog.presentation.trip.log.adapter.TripLogContentAdapter


/**
 * @author mjkim
 * @since 2021/06/06
 **/
class TripLogActivity : BaseActivity<ActivityTripLogBinding>(
    R.layout.activity_trip_log
) {

    private var tripLogAdapter: TripLogAdapter? = null
    private var tripLogContentAdapter: TripLogContentAdapter? = null
    private val tripLogs = arrayListOf<TripLog>()


    override fun setup() {
        init()
        setData()
        setUi()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
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
        tripLogAdapter = TripLogAdapter(this, tripLogs)
        binding.recyclerViewTitle.adapter = tripLogAdapter
        binding.recyclerViewTitle.layoutManager = LinearLayoutManager(this)
            .also { it.orientation = LinearLayoutManager.HORIZONTAL }

        tripLogContentAdapter = TripLogContentAdapter(this, tripLogs)
        binding.recyclerViewContent.adapter = tripLogContentAdapter

    }
}