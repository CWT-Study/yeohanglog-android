package team.triplog.presentation.trip.plan.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import team.triplog.R
import team.triplog.databinding.ActivityTripPlanBinding
import team.triplog.presentation.base.BaseActivity
import team.triplog.presentation.trip.plan.activity.TripPlanActivity.Companion.EXTRA_TRIP_ID


/**
 * Created by Minjae Kim on 2020.12.14.
 *
 * DESC : 진행중인 여행 및 계획 화면
 */
class TripPlanActivity : BaseActivity() {
    private lateinit var binding: ActivityTripPlanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_trip_plan)
        binding.lifecycleOwner = this

        val tripId = intent.getIntExtra(EXTRA_TRIP_ID, NO_TRIP_ID)

        val navController = findNavController(R.id.fragment_trip_plan)
        navController.navInflater.inflate(R.navigation.trip_plan_graph).let { navGraph ->
            if (tripId == NO_TRIP_ID) navGraph.startDestination = R.id.tripPlanNameFragment
            navController.graph = navGraph
        }
    }

    companion object {
        const val EXTRA_TRIP_ID = "EXTRA_TRIP_ID"
        private const val NO_TRIP_ID = -1
    }
}

fun Context.startTripPlanActivity(tripId: Int? = null) {
    startActivity(Intent(this, TripPlanActivity::class.java).apply {
        tripId?.let { putExtra(EXTRA_TRIP_ID, it) }
    })
}