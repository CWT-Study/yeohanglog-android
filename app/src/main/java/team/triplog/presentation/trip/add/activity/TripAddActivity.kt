package team.triplog.presentation.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import team.triplog.R
import team.triplog.databinding.ActivityTripAddBinding
import team.triplog.presentation.activity.TripAddActivity.Companion.EXTRA_TRIP_ID
import team.triplog.presentation.base.BaseActivity
import team.triplog.presentation.trip.plan.activity.TripPlanActivity

class TripAddActivity : BaseActivity() {
    private lateinit var binding: ActivityTripAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_trip_add)
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
        setSupportActionBar(binding.toolbar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setDisplayShowTitleEnabled(false)
        }

        binding.layoutParent.setOnClickListener(onClickListener)
        binding.buttonNext.setOnClickListener(onClickListener)
        binding.buttonPrevious.setOnClickListener(onClickListener)
    }

    private fun setData() {}
    private fun setUi() {}

    private val onClickListener = View.OnClickListener { view ->
        when (view.id) {
            R.id.layout_parent -> {
                currentFocus?.clearFocus()
                hideKeyboard(view)
            }
            R.id.button_next -> {
                // TODO : 이름 및 기간 설정 완료시 다음화면으로 넘어가도록 설정
//                    groupInputName.setVisibility(View.GONE);
//                    groupSelectPeriod.setVisibility(View.VISIBLE);

                // TODO : 임시 화면 연동
                Intent(applicationContext, TripPlanActivity::class.java).apply {
                    startActivity(this)
                }
            }
            R.id.button_previous -> {
                binding.groupInputName.visibility = View.VISIBLE
                binding.groupSelectDate.visibility = View.GONE
            }
        }
    }

    companion object {
        const val EXTRA_TRIP_ID = "EXTRA_TRIP_ID"
    }
}

fun Context.startTripInfoActivity(tripId: Int? = null) {
    startActivity(Intent(this, TripAddActivity::class.java).apply {
        tripId?.let { putExtra(EXTRA_TRIP_ID, it) }
    })
}