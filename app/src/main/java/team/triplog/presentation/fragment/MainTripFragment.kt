package team.triplog.presentation.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import team.triplog.R
import team.triplog.databinding.FragmentMainTripBinding
import team.triplog.presentation.activity.TripInfoActivity
import team.triplog.presentation.adapter.MainTripAdapter

class MainTripFragment : Fragment() {
    private lateinit var binding: FragmentMainTripBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainTripBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        init()
        initViewpager()

        return binding.root
    }

    private fun init() {
        binding.buttonPlus.setOnClickListener(onClickListener)
    }

    private fun initViewpager() {
        val adapter: PagerAdapter = MainTripAdapter(activity!!.supportFragmentManager, binding.tlMainTrip.tabCount)
        binding.viewpager.adapter = adapter
        binding.viewpager.addOnPageChangeListener(TabLayoutOnPageChangeListener(binding.tlMainTrip))
        binding.tlMainTrip.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab) {}
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabSelected(tab: TabLayout.Tab) {
                binding.viewpager.currentItem = tab.position
            }
        })
    }

    private val onClickListener = View.OnClickListener { view: View ->
        when (view.id) {
            R.id.button_plus -> {
                Intent(context, TripInfoActivity::class.java).apply {
                    startActivity(this)
                }
            }
        }
    }
}