package team.triplog.presentation.trip.plan.activity

import android.app.Activity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import team.triplog.R
import team.triplog.databinding.ActivityTripPlanBinding
import team.triplog.presentation.base.BaseActivity

class TripPlanActivity : BaseActivity() {
    private lateinit var binding: ActivityTripPlanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_trip_plan)
        binding.lifecycleOwner = this

        val navController = findNavController(R.id.fragment_trip_plan)
        navController.graph = navController.navInflater.inflate(R.navigation.trip_plan_graph)
    }
}

fun Activity.startTripPlanActivity() {

}