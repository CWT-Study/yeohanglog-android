package team.triplog.presentation.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.fragment.app.Fragment
import team.triplog.R
import team.triplog.databinding.FragmentMainTripPlanBinding
import team.triplog.domain.model.Trip
import team.triplog.presentation.trip.plan.activity.TripPlanActivity
import team.triplog.presentation.adapter.MainTripPlanAdapter
import java.text.SimpleDateFormat
import java.util.*

class MainTripPlanFragment : Fragment(), MainTripPlanAdapter.OnItemClickListener {
    private lateinit var binding: FragmentMainTripPlanBinding

    private val periodFormat = SimpleDateFormat("yyyy.MM.dd", Locale.getDefault())

    private var mainTripPlanAdapter: MainTripPlanAdapter? = null
    private val trips = ArrayList<Trip>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainTripPlanBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        init()
        setUi()

        return binding.root
    }

    private fun init() {
        // TODO : Test code
        trips.add(Trip())
        trips.add(Trip())
        trips.add(Trip())

        mainTripPlanAdapter = MainTripPlanAdapter(trips, this)
        binding.recyclerTripPlan.adapter = mainTripPlanAdapter
    }

    private fun setUi() {
        if (isAdded) {
            binding.groupNoContents.visibility = if (trips.isEmpty()) View.VISIBLE else View.INVISIBLE
        }
    }

    override fun onItemClick(view: View, item: Trip) {
        val intent = Intent(context, TripPlanActivity::class.java)

        // TODO : 임시로 String 형식으로 넘김.
        intent.putExtra("EXTRA_TRIP_NAME", item.name)
        intent.putExtra(
            "EXTRA_TRIP_PERIOD", String.format(
                "%s - %s",
                periodFormat.format(item.startDate),
                periodFormat.format(item.startDate)
            )
        )
        val viewTrip = view.findViewById<View>(R.id.view_trip)
        val pairItem = Pair.create(viewTrip, viewTrip.transitionName)
        val optionsCompat =
            ActivityOptionsCompat.makeSceneTransitionAnimation(Objects.requireNonNull(requireActivity()), pairItem)

        startActivity(intent, optionsCompat.toBundle())
    }
}