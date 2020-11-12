package team.triplog.presentation.main.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import team.triplog.R
import team.triplog.data.local.TripLog
import team.triplog.databinding.FragmentMainHomeBinding
import team.triplog.presentation.activity.TripInfoActivity
import team.triplog.presentation.main.adapter.MainHomeAdapter

import team.triplog.presentation.main.viewmodel.MainHomeViewModel
import team.triplog.presentation.trip.plan.activity.TripPlanActivity
import team.triplog.presentation.trip.plan.adapter.TripPlanDayAdapter

class MainHomeFragment: Fragment() {
    private lateinit var binding: FragmentMainHomeBinding
    private val viewModel: MainHomeViewModel by viewModel()
    private val mainHomeAdapter: MainHomeAdapter by lazy {
        MainHomeAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setup()
    }

    fun  init(){
        binding.layoutTrip.setOnClickListener(onClickListener)
    }

    private fun setup() {

        mainHomeAdapter.apply {
            listener = object: MainHomeAdapter.OnItemClickListener{
                override fun onItemClick(item: TripLog) {
                    Toast.makeText(requireContext(), "ItemClick!", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.recyclerLookBack.run {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mainHomeAdapter
            isNestedScrollingEnabled = false
        }

        setViewModel()
    }

    fun setViewModel(){
        binding.viewModel = viewModel

        viewModel.getTripLogList().observe(requireActivity(), Observer {
            mainHomeAdapter.setTripLogItems(it)
            binding.groupNoContents.visibility = if (it.isEmpty()) View.VISIBLE else View.INVISIBLE
        })

        viewModel.getTrip("").observe(requireActivity(), Observer {
            it?.let {
                binding.textNewTrip.visibility = View.VISIBLE
                binding.layoutTripInfo.visibility = View.INVISIBLE
            } ?: run {
                binding.textNewTrip.visibility = View.INVISIBLE
                binding.layoutTripInfo.visibility = View.VISIBLE
            }
        })

        viewModel.readUser("").observe(requireActivity(), Observer {
            binding.textUserName.text = it?.name
        })
    }


    private val onClickListener = View.OnClickListener { view ->
        when (view.id) {
            R.id.layout_trip -> {
                Intent(
                    context,
                    if (viewModel.getTrip("") == null) TripInfoActivity::class.java else TripPlanActivity::class.java
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

}