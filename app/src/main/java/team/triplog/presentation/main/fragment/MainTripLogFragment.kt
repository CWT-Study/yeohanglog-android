package team.triplog.presentation.main.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import team.triplog.databinding.FragmentMainTripLogBinding
import team.triplog.presentation.trip.log.activity.TripLogActivity
import team.triplog.presentation.main.adapter.MainTripLogAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import team.triplog.data.source.local.entity.TripLog
import team.triplog.presentation.main.viewmodel.MainTripLogViewModel


class MainTripLogFragment : Fragment(){
    private lateinit var binding: FragmentMainTripLogBinding
    private val viewModel: MainTripLogViewModel by viewModel()
    private lateinit var mainTripLogAdapter: MainTripLogAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainTripLogBinding.inflate(inflater, container, false)
        binding.apply {
            lifecycleOwner = this@MainTripLogFragment
            binding.viewModel = this@MainTripLogFragment.viewModel
        }

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        setData()
        setUi()
    }

    private fun init() {
        mainTripLogAdapter = MainTripLogAdapter().apply {
            listener = object : MainTripLogAdapter.OnItemClickListener {
                override fun onItemClick(item: TripLog) {
                    item.drawableId.let {
                        if (it == -1) {
                            Toast.makeText(context, "새로운 아이템 등록", Toast.LENGTH_SHORT).show()
                            Intent(context, TripLogActivity::class.java).apply {
                                startActivity(this)
                            }
                        } else {
                            Toast.makeText(context, "기존 아이템", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
        binding.recyclerTripLog.adapter = mainTripLogAdapter
    }

    private fun setData(){}

    private fun setUi() {}
}
