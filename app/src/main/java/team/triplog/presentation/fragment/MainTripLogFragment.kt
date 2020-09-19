package team.triplog.presentation.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_main_trip_log.*
import team.triplog.R
import team.triplog.domain.model.TripLog
import team.triplog.presentation.activity.TripLogActivity
import team.triplog.presentation.adapter.MainTripLogAdapter


class MainTripLogFragment : Fragment() {

    private var mainTripLogAdapter: MainTripLogAdapter? = null
    private val tripLogs = arrayListOf<TripLog>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_main_trip_log, container, false)
        init()
        setUi()
        return rootView
    }


    private fun init() {

        mainTripLogAdapter = MainTripLogAdapter(context, tripLogs, onClickListener)
        recycler_trip_log.layoutManager = GridLayoutManager(context, 3)
        recycler_trip_log.adapter =mainTripLogAdapter
    }

    private fun setUi() {
        if (isAdded) {
        }
    }

    private val onClickListener =
        View.OnClickListener { view: View ->
            when (view.id) {
                R.id.layout_main -> if (view.tag == null) {
                    Toast.makeText(context, "새로운 아이템 등록", Toast.LENGTH_SHORT).show()
                    val intent = Intent(context, TripLogActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(context, "기존 아이템", Toast.LENGTH_SHORT).show()
                }
            }
        }
}
