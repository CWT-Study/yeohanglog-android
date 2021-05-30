package team.triplog.presentation.trip.plan.activity

import android.content.Context
import android.content.Intent
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import team.triplog.R
import team.triplog.databinding.ActivityTripPlanBinding
import team.triplog.presentation.base.BaseActivity
import team.triplog.presentation.trip.plan.activity.TripPlanActivity.Companion.EXTRA_TRIP_ID
import team.triplog.presentation.util.extension.setupButton
import team.triplog.presentation.viewmodel.ToolbarViewModel


/**
 * 여행 등록/관리 화면
 * @author mjkim
 * @since  2021.05.02
 */
class TripPlanActivity : BaseActivity<ActivityTripPlanBinding>(
    R.layout.activity_trip_plan
) {
    private val navController: NavController by lazy {
        supportFragmentManager.findFragmentById(R.id.fragment_trip_plan).let { fragment ->
            (fragment as NavHostFragment).navController
        }
    }

    override fun setup() {
        setupViewModel()
        setupDestination()
        setupButton()
    }

    private fun setupViewModel() {
        binding.toolbarViewModel = toolbarViewModel
    }

    private fun setupDestination() {
        val tripId = intent.getIntExtra(EXTRA_TRIP_ID, NO_TRIP_ID)
        navController.navInflater.inflate(R.navigation.trip_plan_graph).let { navGraph ->
            if (tripId == NO_TRIP_ID) navGraph.startDestination = R.id.tripPlanNameFragment
            navController.graph = navGraph
        }
    }

    private fun setupButton() {
        binding.btnBack.setupButton(CLICK_SIZE)
    }

    companion object {
        private const val CLICK_SIZE = 0.85F
        const val EXTRA_TRIP_ID = "EXTRA_TRIP_ID"
        private const val NO_TRIP_ID = -1
    }
}

fun Context.startTripPlanActivity(tripId: Int? = null) {
    startActivity(Intent(this, TripPlanActivity::class.java).apply {
        tripId?.let { putExtra(EXTRA_TRIP_ID, it) }
    })
}