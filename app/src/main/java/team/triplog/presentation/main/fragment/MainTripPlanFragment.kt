package team.triplog.presentation.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel
import team.triplog.databinding.FragmentMainTripPlanBinding
import team.triplog.domain.model.Trip
import team.triplog.presentation.activity.startTripInfoActivity
import team.triplog.presentation.adapter.MainTripPlanAdapter
import team.triplog.presentation.main.viewmodel.MainTripPlanViewModel

class MainTripPlanFragment : Fragment(), MainTripPlanAdapter.OnItemClickListener {
    private lateinit var binding: FragmentMainTripPlanBinding

    private val viewModel: MainTripPlanViewModel by viewModel()

    private val adapter: MainTripPlanAdapter by lazy {
        MainTripPlanAdapter(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainTripPlanBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        setup()

        return binding.root
    }

    private fun setup() {
        setViewModel()
        setRecycler()
    }

    private fun setViewModel() {
        binding.vm = viewModel

        viewModel.tripPlanList.observe(viewLifecycleOwner, Observer { list ->
            binding.groupNoContents.isVisible = list.isEmpty()
        })
    }

    private fun setRecycler() {
        binding.recyclerTripPlan.adapter = adapter
    }

    override fun onItemClick(view: View, item: Trip) {
        binding.root.context.startTripInfoActivity()
    }
}