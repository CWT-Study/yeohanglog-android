package team.triplog.presentation.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import team.triplog.R
import team.triplog.databinding.FragmentMainTripLogBinding
import team.triplog.domain.model.TripLog
import team.triplog.presentation.activity.TripLogActivity
import team.triplog.presentation.adapter.MainTripLogAdapter


class MainTripLogFragment : Fragment() {
    private lateinit var binding: FragmentMainTripLogBinding

    private var mainTripLogAdapter: MainTripLogAdapter? = null
    private val tripLogs = arrayListOf<TripLog>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainTripLogBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        init()
        setUi()

        return binding.root
    }


    private fun init() {
        mainTripLogAdapter = MainTripLogAdapter(context, tripLogs, onClickListener)
        binding.recyclerTripLog.adapter = mainTripLogAdapter
    }

    private fun setUi() {}

    private val onClickListener =
        View.OnClickListener { view: View ->
            when (view.id) {
                R.id.layout_main -> {
                    view.tag?.let {
                        Toast.makeText(context, "새로운 아이템 등록", Toast.LENGTH_SHORT).show()
                        Intent(context, TripLogActivity::class.java).apply {
                            startActivity(this)
                        }
                    } ?: run {
                        Toast.makeText(context, "기존 아이템", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
}
