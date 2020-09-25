package team.triplog.presentation.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import team.triplog.R
import team.triplog.databinding.ActivityTripPlanBinding
import team.triplog.presentation.adapter.TripPlanDayAdapter
import team.triplog.presentation.base.BaseActivity
import java.util.*

class TripPlanActivity : BaseActivity() {
    private lateinit var binding: ActivityTripPlanBinding

    private var planDayAdapter: TripPlanDayAdapter? = null
    private val items = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_trip_plan)

        init()
        setData()
        setUi()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        supportFinishAfterTransition()
    }

    override fun onEnterAnimationComplete() {
        super.onEnterAnimationComplete()
    }

    private fun init() {
        planDayAdapter = TripPlanDayAdapter(this, items)
        binding.recyclerTripPlan.apply {
            adapter = planDayAdapter
            isNestedScrollingEnabled = false
        }

        setSupportActionBar(binding.toolbar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setDisplayShowTitleEnabled(false)
        }

        binding.buttonAccount.setOnClickListener(onClickListener)
        binding.buttonCheck.setOnClickListener(onClickListener)
        binding.buttonMember.setOnClickListener(onClickListener)
        binding.buttonPhoto.setOnClickListener(onClickListener)
    }

    private fun setData() {
        //더미데이터ㅎㅎ
        items.add("TEST_DAY1")
        items.add("TEST_DAY2")
        items.add("TEST_DAY3")
        items.add("TEST_DAY4")
        items.add("TEST_DAY5")
        planDayAdapter!!.setItems(items)
    }

    private fun setUi() {
        // TODO : String 형식이 아닌 Trip 객체를 받아서 처리 필요.
        binding.textTitle.text = intent.getStringExtra("EXTRA_TRIP_NAME")
        binding.textTripName.text = intent.getStringExtra("EXTRA_TRIP_NAME")
        binding.textTripPeriod.text = intent.getStringExtra("EXTRA_TRIP_PERIOD")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            supportFinishAfterTransition()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private val onClickListener = View.OnClickListener { view: View ->
        when (view.id) {
            R.id.button_account -> {
                Intent(this, TripAccountActivity::class.java).apply {
                    startActivity(this)
                }
            }
            R.id.button_check -> {
                Intent(this, TripCheckActivity::class.java).apply {
                    startActivity(this)
                }
            }
            R.id.button_member -> {
                Intent(this, TripMemberActivity::class.java).apply {
                    startActivity(this)
                }
            }
            R.id.button_photo -> {
                Intent(this, TripAlbumActivity::class.java).apply {
                    startActivity(this)
                }
            }
        }
    }
}