package team.triplog.presentation.activity

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import team.triplog.R
import team.triplog.databinding.ActivityTripAlbumBinding
import team.triplog.presentation.adapter.TripAlbumAdapter
import java.util.*


class TripAlbumActivity : BaseActivity(), TripAlbumAdapter.OnItemClickListener {
    private lateinit var binding: ActivityTripAlbumBinding

    private var tripAlbumAdapter: TripAlbumAdapter? = null
    private val imageList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_trip_album)

        init()
        setData()
        setUi()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun init() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
            it.setDisplayShowTitleEnabled(false)
        }

        binding.buttonAdd.setOnClickListener(onClickListener)
        initImageList()
    }

    private fun setData() {}
    private fun setUi() {
        updateImageList()
    }

    private fun initImageList() {
        tripAlbumAdapter = TripAlbumAdapter(this, imageList, this)
        binding.recyclerImage.apply {
            layoutManager = GridLayoutManager(applicationContext, 3)
            adapter = tripAlbumAdapter
            isNestedScrollingEnabled = false
        }
    }

    private fun updateImageList() {
        tripAlbumAdapter?.setItems(imageList)
        checkEmptyList()
    }

    private fun checkEmptyList() {
        binding.textNoContents.visibility = if (imageList.isEmpty()) View.VISIBLE else View.INVISIBLE
    }

    private val onClickListener = View.OnClickListener { view: View ->
        when (view.id) {
            R.id.button_add -> {
                // TODO : 사진 추가
            }
        }
    }

    override fun onItemClick(view: View, position: Int) {
        // TODO : 사진 클릭시 디테일 화면 이동
    }
}