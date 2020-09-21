package team.triplog.presentation.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import team.triplog.R
import team.triplog.data.local.User
import team.triplog.databinding.FragmentMainHomeBinding
import team.triplog.domain.model.Trip
import team.triplog.domain.model.TripLog
import team.triplog.presentation.activity.TripInfoActivity
import team.triplog.presentation.activity.TripPlanActivity
import team.triplog.presentation.adapter.MainHomeAdapter
import java.util.*

class MainHomeFragment(
    private val user: User?
) : Fragment(), MainHomeAdapter.OnItemClickListener {
    private lateinit var binding: FragmentMainHomeBinding

    private var homeAdapter: MainHomeAdapter? = null
    private val tripLookBacks = ArrayList<TripLog>()
    private val currentTrip: Trip? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainHomeBinding.inflate(inflater, container, false)
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
        binding.layoutTrip.setOnClickListener(onClickListener)
    }

    private fun setData() {
//        tripLookBacks.add(tripLog);
//        tripLookBacks.add(tripLog2);
//        tripLookBacks.add(tripLog3);

        homeAdapter = MainHomeAdapter(requireContext(), tripLookBacks, this)
        binding.recyclerLookBack.apply {
            adapter = homeAdapter
            isNestedScrollingEnabled = false
        }
    }

    private fun setUi() {
        binding.textUserName.text = user?.name
        binding.groupNoContents.visibility = if (tripLookBacks.isEmpty()) View.VISIBLE else View.INVISIBLE

        currentTrip?.let {
            binding.textNewTrip.visibility = View.VISIBLE
            binding.layoutTripInfo.visibility = View.INVISIBLE
        } ?: run {
            binding.textNewTrip.visibility = View.INVISIBLE
            binding.layoutTripInfo.visibility = View.VISIBLE
        }
    }

    private val onClickListener = View.OnClickListener { view ->
        when (view.id) {
            R.id.layout_trip -> {
                Intent(
                    context,
                    if (currentTrip == null) TripInfoActivity::class.java else TripPlanActivity::class.java
                ).apply {
                    startActivity(this)
                }
            }
            R.id.layout_item -> {
                val (_, title) = view.tag as TripLog
                Toast.makeText(binding.root.context, "$title 화면으로 이동", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onItemClick(item: TripLog) {
        // TODO : item Click
    }
}