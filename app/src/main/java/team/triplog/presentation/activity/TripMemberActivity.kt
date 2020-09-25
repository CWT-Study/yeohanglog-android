package team.triplog.presentation.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import team.triplog.R
import team.triplog.databinding.ActivityTripMemberBinding
import team.triplog.presentation.base.BaseActivity

class TripMemberActivity : BaseActivity() {
    private lateinit var binding: ActivityTripMemberBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_trip_member)

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