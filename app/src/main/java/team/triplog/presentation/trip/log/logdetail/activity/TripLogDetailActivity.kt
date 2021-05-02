package team.triplog.presentation.trip.log.logdetail.activity

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import team.triplog.R
import team.triplog.databinding.ActivityTripLogDetailBinding
import team.triplog.presentation.base.BaseActivity
import kotlin.math.abs


/**
 * @author mjkim
 * @since  2021.05.02
 */
class TripLogDetailActivity :
    BaseActivity<ActivityTripLogDetailBinding>(R.layout.activity_trip_log_detail) {

    override fun setup() {
        init()
        setData()
        setUi()
    }

    private fun init() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setDisplayShowTitleEnabled(false)
        }
    }

    private fun setData() {}

    private fun setUi() {
        binding.viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.viewpager.offscreenPageLimit = 3
        val pageMargin = 180f
        val pageOffset = 180f

        binding.viewpager.setPageTransformer { page: View, position: Float ->
            val myOffset = position * -(2 * pageOffset + pageMargin)
            when {
                position < -1 -> {
                    page.translationX = -myOffset
                }
                position <= 1 -> {
                    val scaleFactor =
                        0.7f.coerceAtLeast(1.toFloat() - abs(x = position - 0.14285715f))
                    page.translationX = myOffset
                    page.scaleY = scaleFactor
                    page.alpha = scaleFactor
                }
                else -> {
                    page.alpha = 0f
                    page.translationX = myOffset
                }
            }
        }
    }
}