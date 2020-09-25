package team.triplog.presentation.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_trip_check.toolbar
import kotlinx.android.synthetic.main.activity_trip_log.*
import team.triplog.R
import team.triplog.databinding.ActivityTripLogBinding
import team.triplog.domain.model.TripLog
import team.triplog.presentation.adapter.TripLogAdapter
import team.triplog.presentation.adapter.TripLogContentAdapter
import team.triplog.presentation.base.BaseActivity

class TripLogActivity : BaseActivity() {
    private lateinit var binding: ActivityTripLogBinding

    private var tripLogAdapter: TripLogAdapter? = null
    private var tripLogContentAdapter: TripLogContentAdapter? = null
    private val tripLogs = arrayListOf<TripLog>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_trip_log)
        binding.lifecycleOwner = this

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
        recyclerView_title.adapter = tripLogAdapter
        recyclerView_title.layoutManager =
            LinearLayoutManager(this).also { it.orientation = LinearLayoutManager.HORIZONTAL }
        tripLogContentAdapter = TripLogContentAdapter(this, tripLogs)
        recyclerView_content.adapter = tripLogContentAdapter

    }
}