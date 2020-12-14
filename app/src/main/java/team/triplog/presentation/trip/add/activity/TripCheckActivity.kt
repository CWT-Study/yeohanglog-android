package team.triplog.presentation.trip.add.activity

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_trip_check.*
import team.triplog.R
import team.triplog.presentation.trip.add.adapter.TripCheckAdapter
import team.triplog.presentation.base.BaseActivity

class TripCheckActivity : BaseActivity() {
    private var checkAdapter: TripCheckAdapter? = null
    private val checkList = arrayListOf<String>()

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

        initList()
    }

    private fun setData() {}

    private fun setUi() {

    }

    private fun initList() {
        checkAdapter = TripCheckAdapter(this, checkList)
        recycler_check.adapter = checkAdapter
        checkEmptyList()
    }

    private fun checkEmptyList() {
        tv_no_contents.visibility = if (checkList.isEmpty()) View.VISIBLE else View.INVISIBLE
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}