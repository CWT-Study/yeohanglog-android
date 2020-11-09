package team.triplog.presentation.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.viewpager.widget.PagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import org.koin.androidx.viewmodel.ext.android.viewModel
import team.triplog.databinding.FragmentMainTripBinding
import team.triplog.presentation.activity.startTripInfoActivity
import team.triplog.presentation.adapter.MainTripAdapter
import team.triplog.presentation.main.viewmodel.MainTripViewModel

class MainTripFragment : Fragment() {
    private lateinit var binding: FragmentMainTripBinding

    private val viewModel: MainTripViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainTripBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        setup()

        return binding.root
    }

    private fun setup() {
        setViewModel()
        setViewpager()
    }


    private fun setViewModel() {
        binding.vm = viewModel

        /** 새로운 여행 등록 클릭 */
        viewModel.eventCreateTrip.observe(viewLifecycleOwner, Observer {
            binding.root.context.startTripInfoActivity()
        })
    }

    private fun setViewpager() {
        val adapter: PagerAdapter =
            MainTripAdapter(
                requireActivity().supportFragmentManager,
                binding.tlMainTrip.tabCount
            )

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
}