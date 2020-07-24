package team.triplog.presentation.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import team.triplog.R;
import team.triplog.presentation.util.TextCountAnimation;

public class TripCheckActivity extends BaseActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerCheck;
    private FloatingActionButton buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_check);

        init();
        setData();
        setUi();
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        buttonAdd = findViewById(R.id.button_add);
        recyclerCheck = findViewById(R.id.recycler_check);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    private void setData() {
    }

    private void setUi() {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
