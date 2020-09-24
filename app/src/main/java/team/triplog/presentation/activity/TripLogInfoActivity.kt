package team.triplog.presentation.activity

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
import team.triplog.databinding.ActivityTripLogInfoBinding
import team.triplog.domain.model.TripLogInfo
import team.triplog.domain.model.TripLogInfoChat
import team.triplog.presentation.adapter.TripLogInfoChatAdapter
import team.triplog.presentation.adapter.TripLogInfoNumAdapter
import team.triplog.presentation.adapter.TripLogInfoViewPagerAdapter
import team.triplog.presentation.util.CenterLayoutManager

class TripLogInfoActivity : BaseActivity() {
    private lateinit var binding: ActivityTripLogInfoBinding

    private val tripLogInfos = arrayListOf<TripLogInfo>()
    private val tripLogInfoChats = arrayListOf<TripLogInfoChat>()

    private var tripLogInfoViewPagerAdapter: TripLogInfoViewPagerAdapter? = null
    private var tripLogInfoNumAdapter: TripLogInfoNumAdapter? = null
    private var tripLogInfoChatAdapter: TripLogInfoChatAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_trip_log_info)
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


        tripLogInfoViewPagerAdapter = TripLogInfoViewPagerAdapter(this, tripLogInfos)
        binding.viewpager.adapter = tripLogInfoViewPagerAdapter

        tripLogInfoChatAdapter = TripLogInfoChatAdapter(this, tripLogInfoChats)
        binding.recyclerViewChat.adapter = tripLogInfoChatAdapter
        binding.recyclerViewChat.layoutManager = LinearLayoutManager(this)

        tripLogInfoNumAdapter = TripLogInfoNumAdapter(this, tripLogInfos)
        binding.recyclerViewNum.adapter = tripLogInfoNumAdapter
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
                var tripLogInfoNum = view?.findViewById<TextView>(R.id.trip_log_info_num)

                viewLocation?.visibility = View.VISIBLE
                viewSelectUser?.visibility = View.VISIBLE
                tripLogInfoNum?.setTextColor(resources.getColor(R.color.trip_log_info_select_num))

                if (position != 0) {
                    viewHolder = binding.recyclerViewNum.findViewHolderForAdapterPosition(position - 1)
                    view = viewHolder?.itemView
                    viewLocation = view?.findViewById(R.id.view_location)
                    viewSelectUser = view?.findViewById(R.id.view_select_user)
                    tripLogInfoNum = view?.findViewById(R.id.trip_log_info_num)
                    viewLocation?.visibility = View.INVISIBLE
                    viewSelectUser?.visibility = View.INVISIBLE
                    tripLogInfoNum?.setTextColor(resources.getColor(R.color.main))
                }
                if (position != tripLogInfos.size - 1) {
                    viewHolder = binding.recyclerViewNum.findViewHolderForAdapterPosition(position + 1)
                    view = viewHolder?.itemView
                    viewLocation = view?.findViewById(R.id.view_location)
                    viewSelectUser = view?.findViewById(R.id.view_select_user)
                    tripLogInfoNum = view?.findViewById(R.id.trip_log_info_num)
                    viewLocation?.visibility = View.INVISIBLE
                    viewSelectUser?.visibility = View.INVISIBLE
                    tripLogInfoNum?.setTextColor(resources.getColor(R.color.main))
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }
        })
        binding.editTripLogInfo.imeOptions = EditorInfo.IME_ACTION_DONE
        binding.editTripLogInfo.setOnEditorActionListener(OnEditorActionListener { textView, actionId, keyEvent ->
            if (actionId == EditorInfo.IME_ACTION_DONE || KeyEvent.getMaxKeyCode() == KeyEvent.KEYCODE_ENTER) {
                val tripLogInfoChat = TripLogInfoChat()
                tripLogInfoChat.sentence = binding.editTripLogInfo.text.toString()
                tripLogInfoChats.add(tripLogInfoChat)
                tripLogInfoChatAdapter!!.notifyDataSetChanged()
                binding.recyclerViewChat.scrollToPosition(tripLogInfoChatAdapter!!.itemCount - 1)
                binding.editTripLogInfo.setText("")
                return@OnEditorActionListener true
            }
            false
        })
    }


}