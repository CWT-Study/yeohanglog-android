package team.triplog.presentation.activity

import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_more_user.*
import team.triplog.R
import team.triplog.data.local.User
import team.triplog.presentation.base.BaseActivity

class MoreUserActivity : BaseActivity() {
    private var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_user)

        init()
        setData()
        setUi()
    }

    private fun init() {
        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
            supportActionBar!!.setDisplayShowTitleEnabled(false)
        }
    }

    private fun setData() {
        // TODO : Room 으로 변경하기 위해 주석처리
//        user = realm?.where(User::class.java)?.findFirst()
    }

    private fun setUi() {
        text_user_name.text = user?.name
        Glide.with(this)
            .load(user?.image)
            .apply(RequestOptions.bitmapTransform(RoundedCorners(16)))
            .thumbnail(0.1f)
            .into(view_user_profile)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}