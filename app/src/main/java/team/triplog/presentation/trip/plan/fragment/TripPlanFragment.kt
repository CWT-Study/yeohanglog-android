package team.triplog.presentation.trip.plan.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import team.triplog.R
import team.triplog.databinding.FragmentTripPlanBinding
import team.triplog.presentation.trip.add.activity.TripPayActivity
import team.triplog.presentation.trip.add.activity.TripAlbumActivity
import team.triplog.presentation.trip.add.activity.TripCheckActivity
import team.triplog.presentation.trip.add.activity.TripMemberActivity
import team.triplog.presentation.base.BaseFragment
import team.triplog.presentation.trip.plan.adapter.TripPlanDayAdapter
import java.util.*

class TripPlanFragment : BaseFragment() {
    private lateinit var binding: FragmentTripPlanBinding

    private val planDayAdapter: TripPlanDayAdapter by lazy {
        TripPlanDayAdapter()
    }
    private val items = ArrayList<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentTripPlanBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setData()
        setUi()
    }

    private fun init() {
        binding.recyclerTripPlan.adapter = planDayAdapter

        // TODO : toolbar 설정 관련해서 navigation 찾아보기.
//        setSupportActionBar(binding.toolbar)
//
//        supportActionBar?.apply {
//            setDisplayHomeAsUpEnabled(true)
//            setDisplayShowHomeEnabled(true)
//            setDisplayShowTitleEnabled(false)
//        }

//        binding.buttonAccount.setOnClickListener(onClickListener)
//        binding.buttonCheck.setOnClickListener(onClickListener)
//        binding.buttonMember.setOnClickListener(onClickListener)
//        binding.buttonPhoto.setOnClickListener(onClickListener)
    }

    private fun setData() {
        //더미데이터ㅎㅎ
        items.add("TEST_DAY1")
        items.add("TEST_DAY2")
        items.add("TEST_DAY3")
        items.add("TEST_DAY4")
        items.add("TEST_DAY5")
        planDayAdapter.setItems(items)
    }

    private fun setUi() {
        // TODO : viewModel 로 데이터 받아오도록 변경 필요.
//        binding.textTitle.text = intent.getStringExtra("EXTRA_TRIP_NAME")
//        binding.textTripName.text = intent.getStringExtra("EXTRA_TRIP_NAME")
//        binding.textTripPeriod.text = intent.getStringExtra("EXTRA_TRIP_PERIOD")
    }

    /**
     * TODO : fragment 구조로 변경하면서 Animation transition 을 사용할 수 없음.
     * TODO : 방식을 조금 더 파악 후에 앱 완성 후, 추가 예정 (MotionLayout 을 활용해도 괜찮을 듯)
     */
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (item.itemId == android.R.id.home) {
//            supportFinishAfterTransition()
//            return true
//        }
//        return super.onOptionsItemSelected(item)
//    }

    private val onClickListener = View.OnClickListener { view: View ->
        /**
         *  TODO : 현재는 Activity 로 이동으로 되어있지만, Fragment 이동으로 변경 예정
         */
        when (view.id) {
            R.id.button_account -> {
                Intent(context, TripPayActivity::class.java).apply {
                    startActivity(this)
                }
            }
            R.id.button_check -> {
                Intent(context, TripCheckActivity::class.java).apply {
                    startActivity(this)
                }
            }
            R.id.button_member -> {
                Intent(context, TripMemberActivity::class.java).apply {
                    startActivity(this)
                }
            }
            R.id.button_photo -> {
                Intent(context, TripAlbumActivity::class.java).apply {
                    startActivity(this)
                }
            }
        }
    }
}