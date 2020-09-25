package team.triplog.presentation.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import team.triplog.R
import team.triplog.databinding.ActivityTripAccountBinding
import team.triplog.presentation.base.BaseActivity
import team.triplog.presentation.util.TextCountAnimation


class TripAccountActivity : BaseActivity() {
    private lateinit var binding: ActivityTripAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_trip_account)

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
        setSupportActionBar(binding.toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
            it.setDisplayShowTitleEnabled(false)
        }
    }

    private fun setData() {}
    private fun setUi() {
        // TODO : 임시로 1,000 을 주도록 설정
        // TODO : 이후 실제 데이터로 변경 필요.
        binding.textTotal.startAnimation(TextCountAnimation(binding.textTotal, 1000))
    }
}