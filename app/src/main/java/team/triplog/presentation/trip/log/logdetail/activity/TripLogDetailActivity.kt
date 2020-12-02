package team.triplog.presentation.trip.log.logdetail.activity

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.TextView.OnEditorActionListener
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import team.triplog.R
import team.triplog.databinding.ActivityTripLogDetailBinding
import team.triplog.domain.model.TripLogDetail
import team.triplog.domain.model.TripLogDetailChat
import team.triplog.presentation.trip.log.logdetail.adapter.TripLogDetailAdapter
import team.triplog.presentation.trip.log.logdetail.adapter.TripLogDetailNumAdapter
import team.triplog.presentation.trip.log.logdetail.adapter.TripLogDetailViewPagerAdapter
import team.triplog.presentation.base.BaseActivity
import team.triplog.presentation.util.CenterLayoutManager

class TripLogDetailActivity : BaseActivity() {
    private lateinit var binding: ActivityTripLogDetailBinding

    private val tripLogDetails = arrayListOf<TripLogDetail>()
    private val tripLogDetailChats = arrayListOf<TripLogDetailChat>()

    private var tripLogDetailViewPagerAdapter: TripLogDetailViewPagerAdapter? = null
    private var tripLogDetailNumAdapter: TripLogDetailNumAdapter? = null
    private var tripLogDetailAdapter: TripLogDetailAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_trip_log_detail)
        binding.lifecycleOwner = this

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

    private fun setData() {


        tripLogDetailViewPagerAdapter = TripLogDetailViewPagerAdapter(this, tripLogDetails)
        binding.viewpager.adapter = tripLogDetailViewPagerAdapter

        tripLogDetailAdapter = TripLogDetailAdapter(this, tripLogDetailChats)
        binding.recyclerViewChat.adapter = tripLogDetailAdapter
        binding.recyclerViewChat.layoutManager = LinearLayoutManager(this)

        tripLogDetailNumAdapter = TripLogDetailNumAdapter(this, tripLogDetails)
        binding.recyclerViewNum.adapter = tripLogDetailNumAdapter
        binding.recyclerViewNum.layoutManager = CenterLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)


    }

    private fun setUi() {
        binding.viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.viewpager.offscreenPageLimit = 3
        val pageMargin = 180f
        val pageOffset = 180f

        binding.viewpager.setPageTransformer(ViewPager2.PageTransformer { page: View, position: Float ->
            val myOffset = position * -(2 * pageOffset + pageMargin)
            if (position < -1) {
                page.translationX = -myOffset
            } else if (position <= 1) {
                val scaleFactor = Math.max(0.7f, 1.toFloat() - Math.abs(position - 0.14285715f))
                page.translationX = myOffset
                page.scaleY = scaleFactor
                page.alpha = scaleFactor
            } else {
                page.alpha = 0f
                page.translationX = myOffset
            }
        })
    }

    private fun setListener() {
        binding.viewpager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.recyclerViewNum.smoothScrollToPosition(position)

                var viewHolder: RecyclerView.ViewHolder? = binding.recyclerViewNum.findViewHolderForAdapterPosition(position)
                var view = viewHolder?.itemView
                var viewLocation = view?.findViewById<View>(R.id.view_location)
                var viewSelectUser = view?.findViewById<View>(R.id.view_select_user)
                var tripLogDetailNum = view?.findViewById<TextView>(R.id.trip_log_detail_num)

                viewLocation?.visibility = View.VISIBLE
                viewSelectUser?.visibility = View.VISIBLE
                tripLogDetailNum?.setTextColor(resources.getColor(R.color.trip_log_detail_select_num))

                if (position != 0) {
                    viewHolder = binding.recyclerViewNum.findViewHolderForAdapterPosition(position - 1)
                    view = viewHolder?.itemView
                    viewLocation = view?.findViewById(R.id.view_location)
                    viewSelectUser = view?.findViewById(R.id.view_select_user)
                    tripLogDetailNum = view?.findViewById(R.id.trip_log_detail_num)
                    viewLocation?.visibility = View.INVISIBLE
                    viewSelectUser?.visibility = View.INVISIBLE
                    tripLogDetailNum?.setTextColor(resources.getColor(R.color.main))
                }
                if (position != tripLogDetails.size - 1) {
                    viewHolder = binding.recyclerViewNum.findViewHolderForAdapterPosition(position + 1)
                    view = viewHolder?.itemView
                    viewLocation = view?.findViewById(R.id.view_location)
                    viewSelectUser = view?.findViewById(R.id.view_select_user)
                    tripLogDetailNum = view?.findViewById(R.id.trip_log_detail_num)
                    viewLocation?.visibility = View.INVISIBLE
                    viewSelectUser?.visibility = View.INVISIBLE
                    tripLogDetailNum?.setTextColor(resources.getColor(R.color.main))
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }
        })
        binding.editTripLogDetail.imeOptions = EditorInfo.IME_ACTION_DONE
        binding.editTripLogDetail.setOnEditorActionListener(OnEditorActionListener { textView, actionId, keyEvent ->
            if (actionId == EditorInfo.IME_ACTION_DONE || KeyEvent.getMaxKeyCode() == KeyEvent.KEYCODE_ENTER) {
                val tripLogDetailChat =
                    TripLogDetailChat()
                tripLogDetailChat.sentence = binding.editTripLogDetail.text.toString()
                tripLogDetailChats.add(tripLogDetailChat)
                tripLogDetailAdapter!!.notifyDataSetChanged()
                binding.recyclerViewChat.scrollToPosition(tripLogDetailAdapter!!.itemCount - 1)
                binding.editTripLogDetail.setText("")
                return@OnEditorActionListener true
            }
            false
        })
    }


}