package team.triplog.presentation.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import team.triplog.R;
import team.triplog.presentation.adapter.TripAlbumAdapter;

public class TripAlbumActivity extends AppCompatActivity implements TripAlbumAdapter.OnItemClickListener {
    private TripAlbumAdapter tripAlbumAdapter;
    private ArrayList<String> imageList = new ArrayList<>();
    private Toolbar toolbar;
    private RecyclerView recyclerImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_album);

        init();
        setData();
        setUi();
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        recyclerImage = findViewById(R.id.recycler_image);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        initImageList();
    }

    private void setData() {
        // TODO : Test code
        imageList.add("");
        imageList.add("");
        imageList.add("");
        imageList.add("");

        tripAlbumAdapter.setItems(imageList);
    }

    private void setUi() {
    }

    private void initImageList() {
        tripAlbumAdapter = new TripAlbumAdapter(this, imageList, this);
        recyclerImage.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
        recyclerImage.setAdapter(tripAlbumAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(View view, int position) {
        // TODO : 사진 클릭시 디테일 화면 이동
    }
}
